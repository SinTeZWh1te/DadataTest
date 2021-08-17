package ru.test.bgbilling.dadata.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author sintezwh1te
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadataResponse<T> implements Serializable {
    @JsonProperty("suggestions")
    private List<Suggestion<T>> suggestionList;

    public List<Suggestion<T>> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion<T>> suggestionList) {
        this.suggestionList = suggestionList;
    }
}
