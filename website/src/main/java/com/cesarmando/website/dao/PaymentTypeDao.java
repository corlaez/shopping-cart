package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.PaymentTypeE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jarma on 4/9/2017.
 */
@Repository
public interface PaymentTypeDao extends CrudRepository<PaymentTypeE, Integer> {

}