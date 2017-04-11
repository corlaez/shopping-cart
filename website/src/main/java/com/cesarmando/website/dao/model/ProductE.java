package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "product", schema = "public")
public class ProductE {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private Integer productTypeId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    @Column(name = "product_type_id")
    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductE productE = (ProductE) o;

        if (id != null ? !id.equals(productE.id) : productE.id != null) return false;
        if (name != null ? !name.equals(productE.name) : productE.name != null) return false;
        if (description != null ? !description.equals(productE.description) : productE.description != null)
            return false;
        if (price != null ? !price.equals(productE.price) : productE.price != null) return false;
        if (active != null ? !active.equals(productE.active) : productE.active != null) return false;
        if (productTypeId != null ? !productTypeId.equals(productE.productTypeId) : productE.productTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        return result;
    }
}
