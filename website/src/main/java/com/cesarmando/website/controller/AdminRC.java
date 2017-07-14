package com.cesarmando.website.controller;

import com.cesarmando.website.config.PostMappingJson;
import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.forms.StoreLogin;
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

    @PostMappingJson(ConsService.adminLogoffP)
    public MyAjaxResponse logoff(HttpSession session) {
        sec.logoff(session);
        return MyAjaxResponse.refresh(true);
    }

    @PostMappingJson(ConsService.adminP + "/{option}/delete/{id}" )
    public MyAjaxResponse delete(
            HttpSession session, @PathVariable String option,
            @PathVariable Integer id) {
        if (!sec.isAdmin(session))
            return MyAjaxResponse
                    .errorMsg("Necesitas estar logeado")
                    .setRedirect("/");
        switch (option){
            case "product": productDao.delete(id); break;
            case "profile":
                if(userDao.count() > 0)
                    userDao.delete(id);
                break;
        }
        return MyAjaxResponse.redirect("/admin/" + option + "/list");
    }
}