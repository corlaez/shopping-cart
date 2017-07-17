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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@RestController
public class PayC {

    @Autowired
    Gson gson;

    @PostMapping(ConsService.payP)
    public MyAjaxResponse pay(
            RedirectAttributes redirectAttr,
            PaymentData paymentData) {
        System.out.println("paymentData: " + paymentData);
//        System.out.println("requestBody: " + requestBody);
//        String paymentDataString = requestBody.substring(23, requestBody.length()-4)
//                .replace("%7B","{")
//                .replace("%22","'")
//                .replace("%7D","}")
//                .replace("%3A",":")
//                .replace("%2C",",");
//        System.out.println("paymentDataString: " + paymentDataString);
//        PaymentData paymentData = gson.fromJson(paymentDataString, PaymentData.class);
//        System.out.println("paymentData: " + paymentData);
//        redirectAttr.addAttribute("paySuccess", true);
//        redirectAttr.addAttribute("payFail", true);
        return MyAjaxResponse.redirect(ConsService.storeP);
    }

//    public static void main(String[] args) {
//        Gson gson = new GsonBuilder()
//                .setDateFormat(DateFormat.LONG)
//                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .setVersion(1.0)
//                .create();
//        PayC payC = new PayC();
//        payC.gson = gson;
//        payC.pay(null, "%7B%22paymentData%22%3A%7B%22name%22%3A%22123%22%2C%22lastname%22%3A%22123%22%2C%22address%22%3A%22123%22%2C%22cardNumber%22%3A%22123%22%2C%22ccv%22%3A%22123123%22%2C%22expirationDate%22%3A%222017-07-27%22%2C%22items%22%3A%22%5B%7B%5C%22id%5C%22%3A8%2C%5C%22cant%5C%22%3A1%2C%5C%22name%5C%22%3A%5C%22Guantes+de+Alpaca+Plomo+Claro%5C%22%2C%5C%22price%5C%22%3A65%2C%5C%22image%5C%22%3A%5C%22http%3A%2F%2Fi63.tinypic.com%2F121ppfs.jpg%5C%22%2C%5C%22available%5C%22%3A50%7D%2C%7B%5C%22id%5C%22%3A9%2C%5C%22cant%5C%22%3A1%2C%5C%22name%5C%22%3A%5C%22Chompa+de+Vicu%C3%B1a+Marron+Claro%5C%22%2C%5C%22price%5C%22%3A75%2C%5C%22image%5C%22%3A%5C%22http%3A%2F%2Fi68.tinypic.com%2Fo7k5ms.jpg%5C%22%2C%5C%22available%5C%22%3A50%7D%2C%7B%5C%22id%5C%22%3A20%2C%5C%22cant%5C%22%3A1%2C%5C%22name%5C%22%3A%5C%22Poncho+de+Vicu%C3%B1a+Beis%5C%22%2C%5C%22price%5C%22%3A80%2C%5C%22image%5C%22%3A%5C%22http%3A%2F%2Fi63.tinypic.com%2F20ars6h.jpg%5C%22%2C%5C%22available%5C%22%3A50%7D%5D%22%7D%7D=");
//
//    }
}