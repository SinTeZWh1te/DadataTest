package ru.test.bgbilling.dadata.bean;

import ru.test.bgbilling.dadata.bean.organization.Organization;
import ru.test.bgbilling.dadata.bean.organization.OrganizationSuggestion;

/**
 * @author sintezwh1te
 */
public class SuggestionTypes {
    public static final SuggestionType<Organization> ORGANIZATION = new OrganizationSuggestion();
}
