package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.ProductTypeE;
import com.cesarmando.website.forms.StoreLogin;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import com.google.gson.Gson;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class StoreC {

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SecurityService securityService;
    @Autowired
    Gson gson;

    @GetMapping({"/", ConsService.storeP})
    public String home(HttpSession session) {
        String lastProductTypeNamePath = (String)
                session.getAttribute(ConsService.lastTypeKey);
        lastProductTypeNamePath = "/" + (
                lastProductTypeNamePath == null ?
                        ConsService.all :
                        (lastProductTypeNamePath));
        return ConsService.redirectStore + lastProductTypeNamePath;
    }

    //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
    @GetMapping({ConsService.storeP + "/{typeName}"})
    public String store(
            HttpSession session, Model model,
            @PathVariable String typeName) {
        List<ProductE> products;
        if (typeName.equalsIgnoreCase("admin")) {
            if (securityService.isAdmin(session))
                return ConsService.redirectAdmin;
            model.addAttribute("admin", true);
        } else {
            if (typeName.equalsIgnoreCase(ConsService.all)) {
                products = productDao.findAllByStockGreaterThanOrderById(0);
            } else {
                //get type
                ProductTypeE type = productTypeDao.findByNameIgnoreCase(typeName);
                if (type != null) {
                    products = productDao.findByProductTypeIdOrderById(type.getId());
                } else {
                    session.setAttribute(ConsService.lastTypeKey, ConsService.all);
                    return ConsService.redirectStore;
                }
            }
            session.setAttribute(ConsService.lastTypeKey, typeName);
            model.addAttribute("products", products);
            String productsJSON = gson.toJson(products);
            model.addAttribute("productsJSON", productsJSON);//for localStorage
        }
        Boolean cartNextVisible = (Boolean) session.getAttribute(ConsService.cartNextVisibleKey);
        if (cartNextVisible == null)
            session.setAttribute(ConsService.cartNextVisibleKey, false);
        model.addAttribute("cartNextVisible", cartNextVisible);
        model.addAttribute("storeLogin", new StoreLogin());
        return "home";
    }


    @PostMapping("/storeLogin")
    public String greetingSubmit(HttpSession session, @ModelAttribute StoreLogin storeLogin) {
        return securityService.login(
                storeLogin.getUsername(),
                storeLogin.getPassword(),
                true,
                session)
                .getRedirect();
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }

    @ModelAttribute("types")
    public List<ProductTypeE> productTypes() {
        var types = productTypeDao
                .findAllByActiveTrueOrderByIdAsc();
        return types;
    }
}
