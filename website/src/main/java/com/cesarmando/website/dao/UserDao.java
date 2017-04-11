package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.UserE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface UserDao extends CrudRepository<UserE, Integer> {

    UserE findByUsername(String username);

}