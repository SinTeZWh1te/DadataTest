package ru.test.bgbilling.dadata.common.bean;

import ru.test.bgbilling.dadata.common.bean.address.Address;
import ru.test.bgbilling.dadata.common.bean.address.AddressSuggestion;
import ru.test.bgbilling.dadata.common.bean.bank.Bank;
import ru.test.bgbilling.dadata.common.bean.bank.BankSuggestion;
import ru.test.bgbilling.dadata.common.bean.organization.Organization;
import ru.test.bgbilling.dadata.common.bean.organization.OrganizationSuggestion;

/**
 * @author sintezwh1te
 */
public class SuggestionTypes {
    public static final SuggestionType<Organization> ORGANIZATION = new OrganizationSuggestion();
    public static final SuggestionType<Address> ADDRESS = new AddressSuggestion();
    public static final SuggestionType<Bank> BANK = new BankSuggestion();
}
