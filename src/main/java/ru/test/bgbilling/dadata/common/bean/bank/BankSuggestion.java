package ru.test.bgbilling.dadata.common.bean.bank;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.test.bgbilling.dadata.common.bean.DadataResponse;
import ru.test.bgbilling.dadata.common.bean.SuggestionType;

/**
 * @author sintezwh1te
 */
public class BankSuggestion implements SuggestionType<Bank> {

    @Override
    public TypeReference<DadataResponse<Bank>> getResponseClass() {
        return new TypeReference<DadataResponse<Bank>>() {
        };
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/bank";
    }
}
