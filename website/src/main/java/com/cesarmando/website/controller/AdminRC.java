package com.cesarmando.website.controller;

import com.cesarmando.website.config.PostMappingJson;
import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@RestController
public class AdminRC {

    @Autowired
    SecurityService sec;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductDao productDao;

    @PostMappingJson({ConsService.adminP + "/{option}/new"})
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

    @PostMappingJson(ConsService.adminLogoffP)
    public MyAjaxResponse logoff(HttpSession session) {
        sec.logoff(session);
        return MyAjaxResponse.redirect(null);
    }
}