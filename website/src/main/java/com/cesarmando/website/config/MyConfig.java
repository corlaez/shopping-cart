package com.cesarmando.website.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by jarma on 4/14/2017.
 */
@Component
public class MyConfig {

    @Autowired
    @Getter
    private org.springframework.core.env.Environment springEnv;

    public String getEnv(String key){
        return System.getenv(key);
    }

    public boolean isTest(){
        return Arrays.stream(springEnv.getActiveProfiles()).anyMatch(p -> p.equals("test"));
    }

    public boolean isProduction() {
        return Boolean.valueOf(getEnv("production"));
    }
}
