package ru.test.bgbilling.dadata.common.bean.bank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sintezwh1te
 */
public class Opf {
    BankType type;
    @JsonProperty("full")
    String fullName;
    @JsonProperty("short")
    String shortName;

    public BankType getType() {
        return type;
    }

    public void setType(BankType type) {
        this.type = type;
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
