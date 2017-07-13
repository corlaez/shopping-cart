package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.ProductTypeE;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.forms.StoreLogin;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@Controller
public class AdminC {

    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SecurityService sec;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductDao productDao;

    @GetMapping({ConsService.adminP})
    public String adminNew() {
        return ConsService.redirect + ConsService.adminP + "/profile/new";
    }

    @GetMapping({ConsService.adminP + "/{option}/new"})
    public String adminNew(
            HttpSession session, Model model,
            @PathVariable String option) {
        if (!sec.isAdmin(session))
            return ConsService.redirectStore;
        model.addAttribute("option", option);
        String destiny = "admin";
        switch (option) {
            case "profile":
                model.addAttribute("obj", ProductE.init());
                break;
            case "product":
                model.addAttribute("obj", ProductE.init());
                break;
            default:
                destiny = ConsService.redirectStore;
        }
        model.addAttribute("objPostPath", ConsService.adminP + "/" + option + "/new");
        return destiny;
    }

    @PostMapping({ConsService.adminP + "/{option}/new"})
    public String adminNewPost(
            HttpSession session, @PathVariable String option,
            ProductE product, UserE profile) {
        if (!sec.isAdmin(session))
            return ConsService.redirectStore;
        String destiny = "/admin/" + option + "/new";
        switch (option) {
            case "profile":
                System.out.println(profile);
                userDao.save(profile);
                break;
            case "product":
                System.out.println(product);
                productDao.save(product);
                break;
            default:
                destiny = ConsService.storeP;
        }
        return ConsService.redirect + destiny;
    }

    @PostMapping(ConsService.adminLoginP)
    public String adminLogin(HttpSession session, @ModelAttribute StoreLogin storeLogin) {
        return sec.login(
                storeLogin.getUsername(),
                storeLogin.getPassword(),
                true,
                session)
                .getRedirect();
    }

    @PostMapping(ConsService.adminLogoffP)
    public String logoff(HttpSession session, @ModelAttribute StoreLogin storeLogin) {
        return sec.login(
                storeLogin.getUsername(),
                storeLogin.getPassword(),
                true,
                session)
                .getRedirect();
    }

    @ModelAttribute("types")
    public List<ProductTypeE> productTypes() {
        var types = productTypeDao.findAllByActiveTrueOrderByIdAsc();
        return types;
    }
}