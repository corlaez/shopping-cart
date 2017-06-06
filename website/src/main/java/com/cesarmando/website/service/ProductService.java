package com.cesarmando.website.service;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.model.ProductE;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jarma on 6/6/2017.
 */
public class ProductService {

    @Autowired
    ProductDao productDao;

//    public List<ProductE> listByType(Integer typeId){
//        return productDao.findAll().stream()
//                .filter(p -> p.getProductTypeId().equals(typeId))
//                .collect(Collectors.toList());
//    }

}
