package ru.test.bgbilling.dadata;

import ru.test.bgbilling.dadata.bean.Suggestion;
import ru.test.bgbilling.dadata.bean.organization.Organization;
import ru.test.bgbilling.dadata.client.DadataClient;

/**
 * @author sintezwh1te
 */
public class DadataTest {
    public static void main(String[] args) throws Exception {
        DadataClient dadataClient = new DadataClient();
        Suggestion<Organization> organization = dadataClient.findOrganizationById("0275034420");
        System.out.println(organization.getData().toString());
    }
}
