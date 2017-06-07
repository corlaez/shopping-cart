package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface UserDao extends JpaRepository<UserE, Integer> {

    UserE findByUsername(String username);

}