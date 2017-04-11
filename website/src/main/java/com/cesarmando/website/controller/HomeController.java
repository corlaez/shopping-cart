package com.cesarmando.website.controller;

import com.cesarmando.website.adapter.restapi.GitHub.GitHubService;
import com.cesarmando.website.adapter.restapi.GitHub.Repo;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.service.SecurityService;
import com.cesarmando.website.service.TestService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import retrofit.Call;
import retrofit.Retrofit;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class HomeController {

    @Autowired
    SecurityService securityService;
    @Autowired
    TestService testService;
    @Autowired
    GitHubService gitHubService;
    @Autowired
    Gson gson;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "redirect:/Hello.xhtml";
    }

    @RequestMapping(value = "/slow/{seconds}", method = RequestMethod.GET)
    @ResponseBody
    String sleep(@PathVariable(name = "seconds") Integer seconds) throws Throwable {
        MyAjaxResponse ar = testService.slow(seconds);
        return gson.toJson(ar);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    String login(@RequestParam String username, @RequestParam String password,
            @RequestParam(required = false) boolean sys,
            HttpSession session) throws Throwable {
        MyAjaxResponse ar = securityService.login(username,password,sys,session);
        return gson.toJson(ar);
    }

    @RequestMapping(value = "/octo-repos", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String consumeApi() throws Throwable {
        List<Repo> repos = gitHubService.listRepos("octocat").execute().body();
        System.out.println(repos.toString());
        MyAjaxResponse ar = new MyAjaxResponse(repos.toString());
        if(System.currentTimeMillis() % 3 == 0)
            throw new Exception("Este es un error simulado para ver AOP en accion");
        return gson.toJson(ar);
    }

}
