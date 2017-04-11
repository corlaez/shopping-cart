package com.cesarmando.website.dao.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by jarma on 4/11/2017.
 */
@Entity
@Table(name = "user", schema = "public")
public class UserE {
    private Integer id;
    private String username;
    private String password;
    private Boolean superuser;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "superuser")
    public Boolean getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Boolean superuser) {
        this.superuser = superuser;
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

        UserE userE = (UserE) o;

        if (id != null ? !id.equals(userE.id) : userE.id != null) return false;
        if (username != null ? !username.equals(userE.username) : userE.username != null) return false;
        if (password != null ? !password.equals(userE.password) : userE.password != null) return false;
        if (superuser != null ? !superuser.equals(userE.superuser) : userE.superuser != null) return false;
        if (active != null ? !active.equals(userE.active) : userE.active != null) return false;
        if (personId != null ? !personId.equals(userE.personId) : userE.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (superuser != null ? superuser.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
