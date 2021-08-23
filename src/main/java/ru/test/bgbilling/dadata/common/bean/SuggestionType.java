package ru.test.bgbilling.dadata.common.bean;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author sintezwh1te
 */
public interface SuggestionType<T> {
    TypeReference<DadataResponse<T>> getResponseClass();

    String getSuggestOperationPrefix();

    default String getFindByIdOperationPrefix() {
        return getSuggestOperationPrefix();
    }
}
