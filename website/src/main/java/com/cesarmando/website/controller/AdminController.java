package com.cesarmando.website.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Local_admin on 6/11/2017.
 */
@Slf4j
@RestController
public class AdminController {

    @GetMapping("/admin")
    public String login() {
        return "login";
    }

}
