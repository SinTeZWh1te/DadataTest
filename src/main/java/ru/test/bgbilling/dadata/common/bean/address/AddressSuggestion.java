package ru.test.bgbilling.dadata.common.bean.address;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.test.bgbilling.dadata.common.bean.DadataResponse;
import ru.test.bgbilling.dadata.common.bean.SuggestionType;

/**
 * @author sintezwh1te
 */
public class AddressSuggestion implements SuggestionType<Address> {
    @Override
    public TypeReference<DadataResponse<Address>> getResponseClass() {
        return new TypeReference<DadataResponse<Address>>() {
        };
    }

    @Override
    public String getSuggestOperationPrefix() {
        return "/address";
    }
}
