package com.cesarmando.website.dao;

import com.cesarmando.website.dao.model.OrderAddressE;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jarma on 4/9/2017.
 */
public interface OrderAddressDao extends CrudRepository<OrderAddressE, Integer> {

}
