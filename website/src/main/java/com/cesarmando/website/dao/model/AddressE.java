package com.cesarmando.website.dao.model;

import javax.persistence.*;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "address", schema = "public")
public class AddressE {
    private Integer id;
    private Integer lat;
    private Integer lng;
    private String geohash;
    private String address;
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
    @Column(name = "lat")
    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lng")
    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "geohash")
    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

        AddressE addressE = (AddressE) o;

        if (id != null ? !id.equals(addressE.id) : addressE.id != null) return false;
        if (lat != null ? !lat.equals(addressE.lat) : addressE.lat != null) return false;
        if (lng != null ? !lng.equals(addressE.lng) : addressE.lng != null) return false;
        if (geohash != null ? !geohash.equals(addressE.geohash) : addressE.geohash != null) return false;
        if (address != null ? !address.equals(addressE.address) : addressE.address != null) return false;
        if (active != null ? !active.equals(addressE.active) : addressE.active != null) return false;
        if (personId != null ? !personId.equals(addressE.personId) : addressE.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (geohash != null ? geohash.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
