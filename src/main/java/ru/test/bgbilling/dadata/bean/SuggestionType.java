package ru.test.bgbilling.dadata.bean;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.test.bgbilling.dadata.bean.DadataResponse;

/**
 * @author sintezwh1te
 */
public interface SuggestionType<T> {
    TypeReference<DadataResponse<T>> getResponseClass();

    String getSuggestOperationPrefix();
}
