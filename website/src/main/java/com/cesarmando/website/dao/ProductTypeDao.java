package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.ProductTypeE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface ProductTypeDao extends JpaRepository<ProductTypeE, Integer> {

}