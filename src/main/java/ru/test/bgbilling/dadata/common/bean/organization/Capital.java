package ru.test.bgbilling.dadata.common.bean.organization;

import java.math.BigDecimal;

/**
 * @author sintezwh1te
 */
public class Capital {
    private String type;
    private BigDecimal value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
