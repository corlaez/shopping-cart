package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "card_info", schema = "public")
public class CardInfoE {
    private Integer id;
    private String cardNumber;
    private String ccvNumber;
    private String currencyName;
    private Boolean active;
    private Integer personId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "ccv_number")
    public String getCcvNumber() {
        return ccvNumber;
    }

    public void setCcvNumber(String ccvNumber) {
        this.ccvNumber = ccvNumber;
    }

    @Basic
    @Column(name = "currency_name")
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardInfoE cardInfoE = (CardInfoE) o;

        if (id != null ? !id.equals(cardInfoE.id) : cardInfoE.id != null) return false;
        if (cardNumber != null ? !cardNumber.equals(cardInfoE.cardNumber) : cardInfoE.cardNumber != null) return false;
        if (ccvNumber != null ? !ccvNumber.equals(cardInfoE.ccvNumber) : cardInfoE.ccvNumber != null) return false;
        if (currencyName != null ? !currencyName.equals(cardInfoE.currencyName) : cardInfoE.currencyName != null)
            return false;
        if (active != null ? !active.equals(cardInfoE.active) : cardInfoE.active != null) return false;
        if (personId != null ? !personId.equals(cardInfoE.personId) : cardInfoE.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (ccvNumber != null ? ccvNumber.hashCode() : 0);
        result = 31 * result + (currencyName != null ? currencyName.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
