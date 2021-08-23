package ru.test.bgbilling.dadata.server.service;

import bitel.billing.server.admin.bean.AddressItem;
import bitel.billing.server.admin.bean.AddressManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.bitel.bgbilling.common.BGException;
import ru.bitel.bgbilling.common.BGMessageException;
import ru.bitel.bgbilling.kernel.container.managed.ServerContext;
import ru.bitel.bgbilling.kernel.container.service.server.AbstractService;
import ru.bitel.bgbilling.kernel.contract.api.common.service.ContractService;
import ru.bitel.bgbilling.kernel.directory.address.AddressCity;
import ru.bitel.bgbilling.kernel.directory.address.AddressCountry;
import ru.bitel.common.Utils;
import ru.bitel.common.logging.BGNestedContext;
import ru.bitel.oss.kernel.entity.common.bean.EntityAttrAddress;
import ru.bitel.oss.kernel.entity.server.utils.AddressUtils;
import ru.test.bgbilling.dadata.client.DadataClient;
import ru.test.bgbilling.dadata.common.bean.Suggestion;
import ru.test.bgbilling.dadata.common.bean.address.Address;
import ru.test.bgbilling.dadata.server.service.common.DadataService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebService(
        endpointInterface = "ru.test.bgbilling.dadata.server.service.common.DadataService"
)
public class DadataServiceImpl extends AbstractService implements DadataService {

    private static final Logger logger = LogManager.getLogger();

    private Connection con;
    private ServerContext serverContext;
    private DadataClient dadataClient;

    public DadataServiceImpl() {
    }

    @PostConstruct
    protected void init() throws BGException {
        BGNestedContext.push("test");
        this.serverContext = ServerContext.get();
        this.con = getConnection();
        this.dadataClient = new DadataClient(getSetup());
    }

    @PreDestroy
    private void destroy() {
        try {
            if (this.con != null) {
                con.commit();
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Suggestion<Address>> suggestAddress(String value) throws BGMessageException {
        List<Suggestion<Address>> result = new ArrayList<>();
        try {
            if (value != null && !value.isEmpty()) {
                result.addAll(this.dadataClient.suggestAddress(value));
            }
        } catch (JsonProcessingException e) {
            throw new BGMessageException(e.getMessage());
        }
        return result;
    }

    @Override
    public Suggestion<Address> getAddress(String fiasCode) throws BGMessageException {
        try {
            if (fiasCode != null && !fiasCode.isEmpty()) {
                return this.dadataClient.findAddressById(fiasCode);
            }
        } catch (JsonProcessingException e) {
            throw new BGMessageException(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateContractParam(Suggestion<Address> addressSuggestion, int contractId, List<Integer> paramIds, String comment, String flat, Integer pod, Integer floor) throws BGMessageException {
        if (addressSuggestion != null) {
            AddressManager addressManager = new AddressManager(con, getSetup());
            AddressCountry addressCountry = addressManager.getAddressCountryByTitle(addressSuggestion.getData().getCountry(), false);
            String region = addressSuggestion.getData().getRegion() == null ? "" : Utils.maskNull(addressSuggestion.getData().getRegionType()) + ". " + Utils.maskNull(addressSuggestion.getData().getRegion()) + " ";
            String area = addressSuggestion.getData().getArea() == null ? "" : Utils.maskNull(addressSuggestion.getData().getAreaType()) + ". " + Utils.maskNull(addressSuggestion.getData().getArea()) + " ";
            String city = addressSuggestion.getData().getCity() == null ? addressSuggestion.getData().getSettlement() : addressSuggestion.getData().getCity();
            AddressCity addressCity = addressManager.getAddressCityByTitle(region + area + city, addressCountry.getId(), true);
            String street = addressSuggestion.getData().getStreetType() + ". " + addressSuggestion.getData().getStreet();
            AddressItem addressStreet = addressManager.getAddressStreetByTitle(street, addressCity.getId(), true);
            int houseId = addressManager.getHouseId(addressCountry.getTitle(), addressCity.getTitle(), addressStreet.getTitle(), addressSuggestion.getData().getHouse(), addressSuggestion.getData().getPostalCode(), true);

            try {
                ContractService contractService = serverContext.getService(ContractService.class, 0);
                for (Integer paramId : paramIds) {
                    EntityAttrAddress entityAttrAddress = new EntityAttrAddress();
                    entityAttrAddress.setHouseId(houseId);
                    entityAttrAddress.setEntitySpecAttrId(paramId);
                    entityAttrAddress.setEntityId(contractId);
                    entityAttrAddress.setFlat(flat);
                    entityAttrAddress.setPod(pod);
                    entityAttrAddress.setFloor(floor);
                    entityAttrAddress.setComment(comment);
                    entityAttrAddress.setTitle(AddressUtils.getAddress(getSetup(), AddressUtils.getAddressStruct(con, houseId, entityAttrAddress), null));
                    contractService.contractParameterUpdate(contractId, entityAttrAddress);
                }
            } catch (BGException | SQLException e) {
                throw new BGMessageException(e.getMessage());
            }
        }
    }
}
