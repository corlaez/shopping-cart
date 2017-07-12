package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.ProductTypeE;
import com.cesarmando.website.forms.StoreLogin;
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
public class StoreC {
    public static final String STORE_PATH = "/store";
    public static final String ALL = "Todo";
    public static final String REDIRECT = "redirect:";
    public static final String REDIRECT_STORE = REDIRECT + STORE_PATH;
    public static final String LAST_TYPE = "$LAST_TYPE$";
    public static final String CART_NEXT_VISIBLE = "CART_NEXT_VISIBLE";

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    Gson gson;

    @GetMapping({"/", STORE_PATH})
    public String home(HttpSession session) {
        String lastProductTypeNamePath = (String) session.getAttribute(LAST_TYPE);
        lastProductTypeNamePath = "/" + (lastProductTypeNamePath == null ? ALL : (lastProductTypeNamePath));
        return REDIRECT_STORE + lastProductTypeNamePath;
    }

    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    @GetMapping({STORE_PATH + "/{typeName}"})
    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    public String store(HttpSession session, Model model, Locale locale,
                        @PathVariable String typeName) {
        //System.out.println(locale.getCountry());
        //get products
        List<ProductE> products;

        if (typeName.equalsIgnoreCase("admin")) {
            model.addAttribute("admin", true);
        } else {
            if (typeName.equalsIgnoreCase(ALL)) {
                products = productDao.findAllByStockGreaterThanOrderById(0);
            } else {
                //get type
                ProductTypeE type = productTypeDao.findByNameIgnoreCase(typeName);
                if (type != null) {
                    products = productDao.findByProductTypeIdOrderById(type.getId());
                } else {
                    session.setAttribute(LAST_TYPE, ALL);
                    return REDIRECT_STORE;
                }
            }
            session.setAttribute(LAST_TYPE, typeName);
            model.addAttribute("products", products);
            String productsJSON = gson.toJson(products);
            model.addAttribute("productsJSON", productsJSON);//for localStorage
        }
        //types for menu, reverse order
        var types = productTypeDao.findAllByActiveTrueOrderByIdAsc();
        model.addAttribute("types", types);
        model.addAttribute("storePath", STORE_PATH);
        Boolean cartNextVisible = (Boolean) session.getAttribute(CART_NEXT_VISIBLE);
        if (cartNextVisible == null)
            session.setAttribute(CART_NEXT_VISIBLE, false);
        model.addAttribute("cartNextVisible", cartNextVisible);
        model.addAttribute("storeLogin", new StoreLogin());
        return "home";
    }


    @PostMapping("/storeLogin")
    public String greetingSubmit(@ModelAttribute StoreLogin storeLogin) {
        System.out.println("storeLogin " + storeLogin);
        return REDIRECT_STORE;
    }

    @GetMapping("/pay/success")
    public String paySuccess(HttpSession session) {
        var cart = session.getAttribute("cart");
        System.out.println("CART SUCCESS" + cart);
        //serviceX.processPayment(session, cart);
        return REDIRECT_STORE;
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
