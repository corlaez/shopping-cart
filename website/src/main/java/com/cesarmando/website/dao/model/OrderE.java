package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "order", schema = "public")
public class OrderE {
    private Integer id;
    private String clientName;
    private String clientPhone;
    private String comment;
    private Integer userId;
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
    @Column(name = "client_name")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Basic
    @Column(name = "client_phone")
    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

        OrderE orderE = (OrderE) o;

        if (id != null ? !id.equals(orderE.id) : orderE.id != null) return false;
        if (clientName != null ? !clientName.equals(orderE.clientName) : orderE.clientName != null) return false;
        if (clientPhone != null ? !clientPhone.equals(orderE.clientPhone) : orderE.clientPhone != null) return false;
        if (comment != null ? !comment.equals(orderE.comment) : orderE.comment != null) return false;
        if (userId != null ? !userId.equals(orderE.userId) : orderE.userId != null) return false;
        if (paymentTypeId != null ? !paymentTypeId.equals(orderE.paymentTypeId) : orderE.paymentTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        return result;
    }
}
