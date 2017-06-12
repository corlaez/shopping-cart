package com.cesarmando.website.controller;

import com.cesarmando.website.service.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Local_admin on 6/11/2017.
 */
@Slf4j
@Controller
public class AdminController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/admin")
    public String login() {
        return "login";
    }

}
