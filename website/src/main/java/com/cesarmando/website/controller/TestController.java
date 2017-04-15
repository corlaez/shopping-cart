package com.cesarmando.website.controller;

import com.cesarmando.website.adapter.restapi.GitHub.GitHubService;
import com.cesarmando.website.config.GetMappingJson;
import com.cesarmando.website.dao.PersonDao;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.service.TestService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    PersonDao personDao;

    @GetMappingJson("/slow/{seconds}")
    public MyAjaxResponse slow(@PathVariable(name = "seconds") Integer seconds) throws Throwable {
        var ar = testService.slow(seconds);
        return ar;
    }

    @GetMappingJson(value = "/userCount")
    public MyAjaxResponse userCount() throws Throwable {
        var userCount = securityService.getUserDao().count();
        return MyAjaxResponse.data("users count: " + userCount);
    }

    @GetMappingJson(value = "/octo-repos")
    public MyAjaxResponse consumeApi() throws Throwable {
        var repos = gitHubService.listRepos("octocat").execute().body();
        System.out.println(repos.toString());
        var ar = new MyAjaxResponse(repos.toString());
        return ar;
    }

    @GetMappingJson(value = "/testAOP")
    public MyAjaxResponse testAOP() throws Throwable {
        throw new Exception("Este es un error simulado para ver AOP en accion");
    }

    @GetMappingJson(value = "/prueba")
    public MyAjaxResponse prueba() throws Throwable{
        var list = new ArrayList<>();
        personDao.findAll().forEach(list::add);
        return MyAjaxResponse.data(list.toString());
    }
}