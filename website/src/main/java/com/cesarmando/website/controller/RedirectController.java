package com.cesarmando.website.controller;

import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * Created by jarma on 4/9/2017.
 */

@Slf4j
@Controller
public class RedirectController {

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("var", 74);
        return "home";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "redirect:/oops.html";
    }

}
