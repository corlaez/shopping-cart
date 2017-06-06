package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class RedirectController {

    @Autowired
    ProductDao productDao;

    @GetMapping(value = "/")
    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    public String home(Model model, @RequestParam(name="type", required=false) Integer type) {
        if(type != null)
            model.addAttribute("products", productDao.findByProductTypeId(type));
        else
            model.addAttribute("products", productDao.findAll());
        return "home";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "redirect:/oops.html";
    }

}
