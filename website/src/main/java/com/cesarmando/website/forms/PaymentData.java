package com.cesarmando.website.forms;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by jarma on 7/10/2017.
 */
@Data
public class PaymentData {
    private String name;
    private String lastname;
    private String address;
    private String cardNumber;
    private String ccv;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String items;
}