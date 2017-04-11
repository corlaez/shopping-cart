package com.cesarmando.website.controller;

import com.cesarmando.website.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jarma on 4/9/2017.
 * Controlador de la pantalla de carrito de compras
 */

@Controller
public class StoreCartController {
    @Autowired
    AddressDao addressDao;


}
