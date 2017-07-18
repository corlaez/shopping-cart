package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.forms.PaymentData;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@Controller
public class PayC {

    @PostMapping(ConsService.payP)
    public String pay(RedirectAttributes redirectAttr, PaymentData paymentData) {
        System.out.println("paymentData: " + paymentData);
        redirectAttr.addAttribute("paySuccess", true);
        //validate

        //save

//        redirectAttr.addAttribute("payFail", true);
        return ConsService.redirectStore;
        //MyAjaxResponse.redirect(ConsService.storeP);
    }
}