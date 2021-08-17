package ru.test.bgbilling.dadata.bean.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.test.bgbilling.dadata.common.LocalDateDeserializer;

import java.time.LocalDate;

/**
 * @author sintezwh1te
 */
public class State {
    @JsonProperty("actuality_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate actualityDate;
    @JsonProperty("registration_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate registrationDate;
    @JsonProperty("liquidation_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate liquidationDate;
    String code;
    OrganizationStatus status;

    public LocalDate getActualityDate() {
        return actualityDate;
    }

    public void setActualityDate(LocalDate actualityDate) {
        this.actualityDate = actualityDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLiquidationDate() {
        return liquidationDate;
    }

    public void setLiquidationDate(LocalDate liquidationDate) {
        this.liquidationDate = liquidationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrganizationStatus getStatus() {
        return status;
    }

    public void setStatus(OrganizationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "State{" +
                "actualityDate=" + actualityDate +
                ", registrationDate=" + registrationDate +
                ", liquidationDate=" + liquidationDate +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
