package ru.test.bgbilling.dadata.common.bean.organization;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sintezwh1te
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Opf {
    String type;
    String code;
    @JsonProperty("full")
    String fullName;
    @JsonProperty("short")
    String shortName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
