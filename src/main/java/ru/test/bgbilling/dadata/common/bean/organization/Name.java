package ru.test.bgbilling.dadata.common.bean.organization;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sintezwh1te
 */
public class Name {
    @JsonProperty("full_with_opf")
    String fullWithOpf;
    @JsonProperty("short_with_opf")
    String shortWithOpf;
    String latin;
    @JsonProperty("full")
    @Deprecated
    String fullName;
    @JsonProperty("short")
    @Deprecated
    String shortName;

    public String getFullWithOpf() {
        return fullWithOpf;
    }

    public void setFullWithOpf(String fullWithOpf) {
        this.fullWithOpf = fullWithOpf;
    }

    public String getShortWithOpf() {
        return shortWithOpf;
    }

    public void setShortWithOpf(String shortWithOpf) {
        this.shortWithOpf = shortWithOpf;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
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

    @Override
    public String toString() {
        return "Name{" +
                "fullWithOpf='" + fullWithOpf + '\'' +
                ", shortWithOpf='" + shortWithOpf + '\'' +
                ", latin='" + latin + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
