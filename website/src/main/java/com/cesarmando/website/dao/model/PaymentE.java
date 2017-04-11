package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "payment", schema = "public")
public class PaymentE {
    private Integer id;
    private BigDecimal amount;
    private String maskedCard;
    private String currenctName;
    private Integer orderId;
    private Integer paymentTypeId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "masked_card")
    public String getMaskedCard() {
        return maskedCard;
    }

    public void setMaskedCard(String maskedCard) {
        this.maskedCard = maskedCard;
    }

    @Basic
    @Column(name = "currenct_name")
    public String getCurrenctName() {
        return currenctName;
    }

    public void setCurrenctName(String currenctName) {
        this.currenctName = currenctName;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "payment_type_id")
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentE paymentE = (PaymentE) o;

        if (id != null ? !id.equals(paymentE.id) : paymentE.id != null) return false;
        if (amount != null ? !amount.equals(paymentE.amount) : paymentE.amount != null) return false;
        if (maskedCard != null ? !maskedCard.equals(paymentE.maskedCard) : paymentE.maskedCard != null) return false;
        if (currenctName != null ? !currenctName.equals(paymentE.currenctName) : paymentE.currenctName != null)
            return false;
        if (orderId != null ? !orderId.equals(paymentE.orderId) : paymentE.orderId != null) return false;
        if (paymentTypeId != null ? !paymentTypeId.equals(paymentE.paymentTypeId) : paymentE.paymentTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (maskedCard != null ? maskedCard.hashCode() : 0);
        result = 31 * result + (currenctName != null ? currenctName.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        return result;
    }
}
