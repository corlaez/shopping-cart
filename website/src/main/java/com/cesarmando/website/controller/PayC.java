package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.forms.StoreLogin;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@Controller
public class PayC {

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SecurityService securityService;

    @GetMapping("/pay/success")
    public String paySuccess(HttpSession session) {
        var cart = session.getAttribute("cart");
        System.out.println("CART SUCCESS" + cart);
        //serviceX.processPayment(session, cart);
        return ConsService.redirectStore;
    }

    @GetMapping("/pay/fail")
    public String payFail(HttpSession session) {
        System.out.println("CART FAIL");
        session.setAttribute("cart", null);
        return "redirect:/store";
    }

}