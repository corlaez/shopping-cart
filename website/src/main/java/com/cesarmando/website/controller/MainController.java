package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.ProductTypeE;
import com.google.gson.Gson;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class MainController {
    public static final String STORE_PATH = "/store";
    public static final String ALL_PATH = "/Todo";
    public static final String ALL_PATH2 = "/todo";
    public static final String LAST_TYPE = "$LAST_TYPE$";
    public static final String CART_NEXT_VISIBLE = "CART_NEXT_VISIBLE";

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    Gson gson;

    @GetMapping({"/", "/store"})
    public String home(HttpSession session) {
        String lastProductTypeNamePath = (String) session.getAttribute(LAST_TYPE);
        lastProductTypeNamePath = lastProductTypeNamePath == null ? ALL_PATH : ("/" + lastProductTypeNamePath);
        return "redirect:" + STORE_PATH + lastProductTypeNamePath;
    }

    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    @GetMapping({STORE_PATH + ALL_PATH, STORE_PATH + ALL_PATH2, STORE_PATH + "/{typeName}"})
    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    public String store(HttpSession session, Model model, Locale locale,
            @PathVariable(required=false) String typeName) {
        System.out.println(locale.getCountry());
        //todo make viewModel and encapsulate in service
        //get typeId
        ProductTypeE type = productTypeDao.findByNameIgnoreCase(typeName);
        if(typeName != null && type == null){
            return "redirect:/store";
        }
        typeName = typeName == null ? "Todo" : typeName;
        //products for templating
        List<ProductE> products;
        if(type != null) {
            products = productDao.findByProductTypeIdOrderById(type.getId());
        }
        else
            products = productDao.findAllByStockGreaterThanOrderById(0);
        model.addAttribute("products", products);
        //products for localStorage
        String productsJSON = gson.toJson(products);
        System.out.println(productsJSON);
        model.addAttribute("productsJSON", productsJSON);
        //types for menu, reverse order
        var types = productTypeDao.findAllByActiveTrueOrderByIdAsc();
        model.addAttribute("types", types);
        model.addAttribute("storePath", STORE_PATH);
        //session last type
        session.setAttribute(LAST_TYPE, typeName);
        //session last type
        Boolean cartNextVisible = (Boolean)session.getAttribute(CART_NEXT_VISIBLE);
        if(cartNextVisible == null)
            session.setAttribute(CART_NEXT_VISIBLE, false);
        model.addAttribute("cartNextVisible", cartNextVisible);
        return "home";
    }

    @GetMapping("/pay/success")
    public String paySuccess(HttpSession session) {
        var cart = session.getAttribute("cart");
        System.out.println("CART SUCCESS" + cart);
        //serviceX.processPayment(session, cart);
        return "redirect:/store";
    }

    @GetMapping("/pay/fail")
    public String payFail(HttpSession session) {
        System.out.println("CART FAIL");
        session.setAttribute("cart", null);
        return "redirect:/store";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }

    @ModelAttribute("homeServer")
    public String homeServer() {
        return "http://localhost:8080";
    }
}
