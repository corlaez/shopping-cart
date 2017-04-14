package com.cesarmando.website.controller;

import com.cesarmando.website.adapter.restapi.GitHub.GitHubService;
import com.cesarmando.website.adapter.restapi.GitHub.Repo;
import com.cesarmando.website.config.GetMappingJson;
import com.cesarmando.website.config.PostMappingJson;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.service.TestService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import retrofit.Call;
import retrofit.Retrofit;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private Environment environment;
    @Autowired
    SecurityService securityService;
    @Autowired
    GitHubService gitHubService;
    @Autowired
    Gson gson;

    @PostMappingJson("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        @RequestParam(required = false) boolean sys,
                        HttpSession session) throws Throwable {
        MyAjaxResponse ar = securityService.login(username,password,sys,session);
        return gson.toJson(ar);
    }

    @GetMappingJson(value = "/profiles")
    public MyAjaxResponse profiles(HttpServletResponse res) throws Throwable {
        String profiles = Arrays.deepToString(environment.getActiveProfiles());
        log.warn("Active profiles: {}", profiles);
        //res.sendRedirect("/");
        return MyAjaxResponse.data(profiles);
    }

}