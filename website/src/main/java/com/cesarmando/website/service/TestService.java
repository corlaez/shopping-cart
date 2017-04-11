package com.cesarmando.website.service;

import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by jarma on 4/11/2017.
 */
@Service
@Slf4j
public class TestService {

    @SneakyThrows
    public MyAjaxResponse slow(int seconds){
        MyAjaxResponse ar = new MyAjaxResponse();
        if(seconds < 0 || seconds > 20)
            return ar.setErrorMsg("Error, parametro segundos, [0;20], demasiado grande.");
        Thread.sleep(seconds * 1000L);
        return ar.setData("Respuesta lenta enviada luego de " + seconds + " segundos.");
    }

}