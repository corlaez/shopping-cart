package com.cesarmando.website.controller;

import com.cesarmando.website.adapter.restapi.GitHub.GitHubService;
import com.cesarmando.website.adapter.restapi.GitHub.Repo;
import com.cesarmando.website.config.GetMappingJson;
import com.cesarmando.website.config.PostMappingJson;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.service.TestService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@RestController
public class TestController {

    @Autowired
    SecurityService securityService;
    @Autowired
    TestService testService;
    @Autowired
    GitHubService gitHubService;
    @Autowired
    Gson gson;

    @GetMappingJson("/slow/{seconds}")
    public String slow(@PathVariable(name = "seconds") Integer seconds) throws Throwable {
        MyAjaxResponse ar = testService.slow(seconds);
        return gson.toJson(ar);
    }

    @GetMappingJson(value = "/userCount")
    public String userCount() throws Throwable {
        return gson.toJson(MyAjaxResponse.data("users count: " + securityService.getUserDao().count()));
    }

    @GetMappingJson(value = "/octo-repos")
    public String consumeApi() throws Throwable {
        List<Repo> repos = gitHubService.listRepos("octocat").execute().body();
        System.out.println(repos.toString());
        MyAjaxResponse ar = new MyAjaxResponse(repos.toString());
        return gson.toJson(ar);
    }

    @GetMappingJson(value = "/testAOP")
    public String testAOP() throws Throwable {
        throw new Exception("Este es un error simulado para ver AOP en accion");
    }

}