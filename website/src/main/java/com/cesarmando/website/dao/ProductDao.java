package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.ProductE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface ProductDao extends JpaRepository<ProductE, Integer> {
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<ProductE> findByProductTypeIdOrderById(int productTypeId);
    List<ProductE> findAllByStockGreaterThanOrderById(int minumunStock);
}