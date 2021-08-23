package ru.test.bgbilling.dadata.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.test.bgbilling.dadata.common.bean.address.Address;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

/**
 * @author sintezwh1te
 */
@XmlSeeAlso({Address.class})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Suggestion<T> implements Serializable {
    private String value;
    @JsonProperty("unrestricted_value")
    private String unrestrictedValue;
    private T data;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnrestrictedValue() {
        return unrestrictedValue;
    }

    public void setUnrestrictedValue(String unrestrictedValue) {
        this.unrestrictedValue = unrestrictedValue;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
