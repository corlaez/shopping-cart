package com.cesarmando.website.controller;

import com.cesarmando.website.config.GetMappingJson;
import com.cesarmando.website.config.MyConfig;
import com.cesarmando.website.config.PostMappingJson;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@RestController
public class StoreRC {

    @Autowired
    SecurityService securityService;
    @Autowired
    MyConfig myConfig;

    @PostMappingJson("/login")
    public MyAjaxResponse login(@RequestParam String username, @RequestParam String password,
                                @RequestParam(required = false) boolean sys,
                                HttpSession session) throws Throwable {
        MyAjaxResponse ar = securityService.login(username, password, sys, session);
        return ar;
    }

    @GetMappingJson("/logoff")
    public MyAjaxResponse logoff(HttpSession session) throws Throwable {
        MyAjaxResponse ar = securityService.logoff(session);
        return ar;
    }

    @GetMappingJson(value = "/profiles")
    public MyAjaxResponse profiles(HttpServletResponse res) throws Throwable {
        String profiles = myConfig.getProfilesString();
        log.warn("Active profiles: {}", profiles);
        if(myConfig.isProduction())
            res.sendRedirect("/");
        return MyAjaxResponse.data(profiles);
    }

    @PostMappingJson("/beforePay")
    public MyAjaxResponse beforePay(@RequestBody String cart, HttpSession session) throws Throwable {
        session.setAttribute("cart", cart);
        return MyAjaxResponse.data("");
    }

    @GetMappingJson("/cartNextVisible/{nextVisible}")
    public MyAjaxResponse toogleCart(HttpSession session, @PathVariable Boolean nextVisible) throws Throwable {
        session.setAttribute(ConsService.cartNextVisibleKey, nextVisible);
        return MyAjaxResponse.data("" + nextVisible);
    }
}