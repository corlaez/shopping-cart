package com.cesarmando.website.service;

import com.cesarmando.website.dao.PersonDao;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.viewmodel.MyAjaxResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by jarma on 4/11/2017.
 */
@Service("sec")
@Slf4j
public class SecurityService {

    @Autowired @Getter
    UserDao userDao;
    @Autowired
    PersonDao personDao;

    public MyAjaxResponse login(String username, String password, boolean sys, HttpSession session){
        MyAjaxResponse ajaxResponse = new MyAjaxResponse();
        UserE user = userDao.findByUsername(username);
        log.info("username found: {}. request system access: {}", user != null, sys);
        if(user != null && password.equals(user.getPassword())){
            if(!sys || (sys && user.getSuperuser())) {
                session.setAttribute("username", personDao.findOne(user.getPersonId()).getName());
                session.setAttribute("user", user);
                if(user.getSuperuser())
                    session.setAttribute("admin", true);
                ajaxResponse.setRedirect("/admin");
                return ajaxResponse;
            }
        }
        ajaxResponse.setRedirect("/");
        ajaxResponse.setErrorMsg("Combinación usuario y contraseña inválida.");
        return ajaxResponse;
    }

    public MyAjaxResponse logoff(HttpSession session){
        session.invalidate();
        MyAjaxResponse ajaxResponse = new MyAjaxResponse();
        return ajaxResponse;
    }

    public boolean isAdmin(HttpSession session){
        if(session == null) return false;
        Boolean isAdmin = (Boolean) session.getAttribute("admin");
        return isAdmin == null ? false : isAdmin;
    }

//    public UserE getUser(HttpSession session){
//        UserE user = (UserE) session.getAttribute("user");
//        return user;
//    }
}