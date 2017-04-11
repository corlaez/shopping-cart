package com.cesarmando.website.service;

import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by jarma on 4/11/2017.
 */
@Service
@Slf4j
public class SecurityService {

    @Autowired
    UserDao userDao;

    public MyAjaxResponse login(String username, String password, boolean sys, HttpSession session){
        MyAjaxResponse ajaxResponse = new MyAjaxResponse();
        UserE user = userDao.findByUsername(username);
        log.info("username found: {}. request system access: {}", user != null, sys);
        if(user != null && password.equals(user.getPassword())){
            if(!sys || (sys && user.getSuperuser())) {
                session.setAttribute("logged", true);
                return ajaxResponse;
            }
        }
        ajaxResponse.setErrorMsg("Combinación usuario y contraseña inválida.");
        return ajaxResponse;
    }

}