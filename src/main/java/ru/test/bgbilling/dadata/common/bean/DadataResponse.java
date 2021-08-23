package ru.test.bgbilling.dadata.common.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.test.bgbilling.dadata.common.bean.address.Address;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.List;

/**
 * @author sintezwh1te
 */
@XmlRootElement
@XmlSeeAlso({Address.class})
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
