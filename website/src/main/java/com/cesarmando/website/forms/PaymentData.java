package com.cesarmando.website.forms;

import com.cesarmando.website.dao.model.ProductE;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

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
    private List<ProductE> items;
}