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
    String perfil = "perfil";
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
    @Getter
    public static final
    String adminP = "/admin";
    @Getter
    public static final
    String adminLoginP = adminP + "/login";
    @Getter
    public static final
    String adminLogoffP = adminP + "/logoff";
    @Getter
    public static final
    String deleteProductP = adminP + "/product/delete/";
    @Getter
    public static final
    String deleteProfileP = adminP + "/profile/delete/";

    //redirects
    @Getter
    public static final
    String redirectStore = redirect + storeP;
    @Getter
    public static final
    String redirectAdmin = redirect + adminP;

    //keys
    @Getter
    public static final
    String lastTypeKey = "$lastTypeKey$";
    @Getter
    public static final
    String cartNextVisibleKey = "$cartNextVisibleKey$";

}