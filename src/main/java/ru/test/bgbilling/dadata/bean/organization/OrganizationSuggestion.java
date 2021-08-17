package ru.test.bgbilling.dadata.bean.organization;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.test.bgbilling.dadata.bean.DadataResponse;
import ru.test.bgbilling.dadata.bean.SuggestionType;

/**
 * @author sintezwh1te
 */
public class OrganizationSuggestion implements SuggestionType<Organization> {
    @Override
    public TypeReference<DadataResponse<Organization>> getResponseClass() {
        return new TypeReference<DadataResponse<Organization>>() {
        };
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/party";
    }
}
