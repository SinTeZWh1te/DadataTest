package ru.test.bgbilling.dadata.common.bean.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.test.bgbilling.dadata.common.bean.AdditionalProperties;
import ru.test.bgbilling.dadata.common.bean.Suggestion;
import ru.test.bgbilling.dadata.common.bean.address.Address;
import ru.test.bgbilling.dadata.common.bean.organization.State;

import java.util.List;

/**
 * @author sintezwh1te
 */
public class Bank extends AdditionalProperties {
    Opf opf;
    Name name;
    String bic;
    String swift;
    String okpo;
    @JsonProperty("correspondent_account")
    String correspondentAccount;
    @JsonProperty("treasury_accounts")
    List<String> treasuryAccounts;
    @JsonProperty("registration_number")
    String registrationNumber;
    String rkc;
    Suggestion<Address> address;
    List<String> phones;
    State state;

    public Opf getOpf() {
        return opf;
    }

    public void setOpf(Opf opf) {
        this.opf = opf;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public List<String> getTreasuryAccounts() {
        return treasuryAccounts;
    }

    public void setTreasuryAccounts(List<String> treasuryAccounts) {
        this.treasuryAccounts = treasuryAccounts;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRkc() {
        return rkc;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    public Suggestion<Address> getAddress() {
        return address;
    }

    public void setAddress(Suggestion<Address> address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
