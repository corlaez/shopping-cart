package com.cesarmando.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by jarma on 7/25/2017.
 */
@Controller
public class JavascriptC {

    private TemplateEngine jsTemplating;

    public JavascriptC(TemplateEngine jsTemplating) {
        this.jsTemplating = jsTemplating;
    }

//    @GetMapping("/service-worker.js")
//    @ResponseBody
//    public String serviceWorker() {
//        String text = jsTemplating
//                .process("service-worker", new Context());
//        return "";
//    }

}
