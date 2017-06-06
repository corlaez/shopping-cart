package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.model.ProductE;
import com.google.gson.Gson;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class RedirectController {

    @Autowired
    ProductDao productDao;
    @Autowired
    Gson gson;

    @GetMapping(value = "/")
    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    public String home(Model model, @RequestParam(name="type", required=false) Integer type) {
        List<ProductE> products;
        if(type != null)
            products = productDao.findByProductTypeId(type);
        else
            products = productDao.findAll();
        String productsJSON = gson.toJson(products);
        System.out.println(productsJSON);
        model.addAttribute("products", products);
        model.addAttribute("productsJSON", productsJSON);
        return "home";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "redirect:/oops.html";
    }

}
