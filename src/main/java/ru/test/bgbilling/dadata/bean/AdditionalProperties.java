package ru.test.bgbilling.dadata.bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sintezwh1te
 */
public class AdditionalProperties {
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void setAdditionalProperties(String name, Object value) {
        additionalProperties.put(name, value);
    }
}
