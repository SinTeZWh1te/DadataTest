package ru.test.bgbilling.dadata.common.bean.bank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sintezwh1te
 */
public class Name {
    String payment;
    @JsonProperty("full")
    String fullName;
    @JsonProperty("short")
    String shortName;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
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