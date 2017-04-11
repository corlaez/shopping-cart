package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "config", schema = "public")
public class ConfigE {
    private Integer id;
    private String company;
    private String currencySymbol;
    private String currencyName;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "currency_symbol")
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @Basic
    @Column(name = "currency_name")
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigE configE = (ConfigE) o;

        if (id != null ? !id.equals(configE.id) : configE.id != null) return false;
        if (company != null ? !company.equals(configE.company) : configE.company != null) return false;
        if (currencySymbol != null ? !currencySymbol.equals(configE.currencySymbol) : configE.currencySymbol != null)
            return false;
        if (currencyName != null ? !currencyName.equals(configE.currencyName) : configE.currencyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (currencySymbol != null ? currencySymbol.hashCode() : 0);
        result = 31 * result + (currencyName != null ? currencyName.hashCode() : 0);
        return result;
    }
}
