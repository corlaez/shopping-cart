package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    ProductDao productDao;
    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SecurityService sec;

    @GetMapping({ConsService.adminP + "/{option}/new"})
    public String admin(
            HttpSession session, Model model,
            @PathVariable String option) {
        if (!sec.isAdmin(session))
            return ConsService.redirectStore;
        option = option == null ? "profile" : option;
        model.addAttribute("type", option);
        String destiny = "admin";
        switch (option) {
            case "profile":
                model.addAttribute("obj", new UserE());
                break;
            default:
                destiny = ConsService.storeP;
        }
        return destiny;
    }

    @PostMapping(ConsService.adminLoginP)
    public String greetingSubmit(HttpSession session, @ModelAttribute StoreLogin storeLogin) {
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
        var types = productTypeDao
                .findAllByActiveTrueOrderByIdAsc();
        return types;
    }
}