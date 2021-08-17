package ru.test.bgbilling.dadata.bean.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.test.bgbilling.dadata.bean.AdditionalProperties;
import ru.test.bgbilling.dadata.common.LocalDateDeserializer;

import java.time.LocalDate;

/**
 * @author sintezwh1te
 */
public class Organization extends AdditionalProperties {
    private String kpp;
    private Capital capital;
    private Management management;
    private String hid;
    private OrganizationType type;
    private State state;
    private Opf opf;
    private String inn;
    private String ogrn;
    @JsonProperty("ogrn_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate ogrnDate;
    private String okpo;
    private String okato;
    private String oktmo;
    private String okogu;
    private String okfs;
    private String okved;
    @JsonProperty("okved_type")
    String okvedType;

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public Management getManagement() {
        return management;
    }

    public void setManagement(Management management) {
        this.management = management;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Opf getOpf() {
        return opf;
    }

    public void setOpf(Opf opf) {
        this.opf = opf;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public LocalDate getOgrnDate() {
        return ogrnDate;
    }

    public void setOgrnDate(LocalDate ogrnDate) {
        this.ogrnDate = ogrnDate;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getOkato() {
        return okato;
    }

    public void setOkato(String okato) {
        this.okato = okato;
    }

    public String getOktmo() {
        return oktmo;
    }

    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    public String getOkogu() {
        return okogu;
    }

    public void setOkogu(String okogu) {
        this.okogu = okogu;
    }

    public String getOkfs() {
        return okfs;
    }

    public void setOkfs(String okfs) {
        this.okfs = okfs;
    }

    public String getOkved() {
        return okved;
    }

    public void setOkved(String okved) {
        this.okved = okved;
    }

    public String getOkvedType() {
        return okvedType;
    }

    public void setOkvedType(String okvedType) {
        this.okvedType = okvedType;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "kpp='" + kpp + '\'' +
                ", capital=" + capital +
                ", management=" + management +
                ", hid='" + hid + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", opf=" + opf +
                ", inn='" + inn + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", ogrnDate=" + ogrnDate +
                ", okpo='" + okpo + '\'' +
                ", okato='" + okato + '\'' +
                ", oktmo='" + oktmo + '\'' +
                ", okogu='" + okogu + '\'' +
                ", okfs='" + okfs + '\'' +
                ", okved='" + okved + '\'' +
                ", okvedType='" + okvedType + '\'' +
                '}';
    }
}
