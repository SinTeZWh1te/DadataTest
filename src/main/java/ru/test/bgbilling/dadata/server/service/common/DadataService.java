package ru.test.bgbilling.dadata.server.service.common;

import ru.bitel.bgbilling.common.BGMessageException;
import ru.test.bgbilling.dadata.common.bean.Suggestion;
import ru.test.bgbilling.dadata.common.bean.address.Address;

import javax.jws.WebService;
import java.util.List;

/**
 * @author sintezwh1te@gmail.com
 */
@WebService
public interface DadataService {

    List<Suggestion<Address>> suggestAddress(String value) throws BGMessageException;

    Suggestion<Address> getAddress(String fiasCode) throws BGMessageException;

    void updateContractParam(Suggestion<Address> addressSuggestion, int contractId, List<Integer> paramIds, String comment, String flat, Integer pod, Integer floor) throws BGMessageException;
}
