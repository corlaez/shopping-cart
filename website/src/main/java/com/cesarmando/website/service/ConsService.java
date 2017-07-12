package com.cesarmando.website.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by jarma on 4/11/2017.
 */
@Service("cons")
@Slf4j

public class ConsService {
    //words
    @Getter
    public static final
    String homeServer = "http://localhost:8080";
    @Getter
    public static final
    String all = "Todo";
    @Getter
    public static final
    String redirect = "redirect:";

    //paths
    @Getter
    public static final
    String storeP = "/store";
    @Getter
    public static final
    String storeAllP = storeP + "/" + all;

    //redirects
    @Getter
    public static final
    String redirectStore = redirect + storeP;

    //keys
    @Getter
    public static final
    String lastTypeKey = "$lastTypeKey$";
    @Getter
    public static final
    String cartNextVisibleKey = "$cartNextVisibleKey$";
}