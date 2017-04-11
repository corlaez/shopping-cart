package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.ProductE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface ProductDao extends CrudRepository<ProductE, Integer> {

}