package ru.test.bgbilling.dadata.common.bean.organization;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.test.bgbilling.dadata.common.bean.DadataResponse;
import ru.test.bgbilling.dadata.common.bean.SuggestionType;

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
