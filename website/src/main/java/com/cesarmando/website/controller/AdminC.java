package com.cesarmando.website.controller;

import com.cesarmando.website.dao.ProductDao;
import com.cesarmando.website.dao.ProductTypeDao;
import com.cesarmando.website.dao.UserDao;
import com.cesarmando.website.dao.model.ProductE;
import com.cesarmando.website.dao.model.ProductTypeE;
import com.cesarmando.website.dao.model.UserE;
import com.cesarmando.website.forms.StoreLogin;
import com.cesarmando.website.service.ConsService;
import com.cesarmando.website.service.SecurityService;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jarma on 4/9/2017.
 */
@Slf4j
@Controller
public class AdminC {

    @Autowired
    ProductTypeDao productTypeDao;
    @Autowired
    SecurityService sec;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductDao productDao;

    @GetMapping({ConsService.adminP})
    public String adminHome(HttpSession session) {
        if (!sec.isAdmin(session))
            return ConsService.redirectStore;
        int userId = ((UserE)session.getAttribute("user")).getId();
        return ConsService.redirect + ConsService.adminP + "/profile/" + userId;
    }

    @GetMapping({ConsService.adminP + "/{option}/{viewType}"})
    public String adminCrud(
            HttpSession session, Model model,
            @PathVariable String option,
            @PathVariable String viewType) {
        if (!sec.isAdmin(session))
            return ConsService.redirectStore;
        model.addAttribute("option", option);
        model.addAttribute("viewType", viewType);
        String destiny = "admin";
        boolean success;//
        switch (viewType) {
            case "new":
                success = handleNewOrEdit(option, model, null);
                break;
            case "list":
                success = handleList(option, model);
                break;
            default:
                success = handleNewOrEdit(option, model, Integer.parseInt(viewType));
        }
        if(!success)//
            destiny = "error";//
        return destiny;
    }

    private boolean handleList(String option, Model model) {
        List<?> list;
        switch (option) {
            case "profile":
                list = userDao.findAllByOrderById();
                break;
            case "product":
                list = productDao.findAllByOrderById();
                break;
            default:
                return false;
        }
        model.addAttribute("list", list);
        return true;
    }

    private boolean handleNewOrEdit(String option, Model model, Integer idObjToEdit) {
        boolean isNew = idObjToEdit == null;
        String newOrEdit = isNew ? "Nuevo" : "Editar";
        model.addAttribute("newOrEdit", newOrEdit);
        Object objToEdit;
        switch (option) {
            case "profile":
                if(isNew) objToEdit = new UserE();
                else objToEdit = userDao.findOne(idObjToEdit);
                break;
            case "product":
                if(isNew) objToEdit = new ProductE();
                else objToEdit = productDao.findOne(idObjToEdit);
                break;
            default:
                return false;
        }
        model.addAttribute("obj", objToEdit);
        String viewType = isNew ? "new" : idObjToEdit.toString();
        String objPostPath = ConsService.adminP + "/" + option + "/" + viewType;
        model.addAttribute("objPostPath", objPostPath);
        return true;
    }

    @PostMapping(ConsService.adminLoginP)
    public String adminLogin(HttpSession session, @ModelAttribute StoreLogin storeLogin) {
        return sec.login(
                storeLogin.getUsername(),
                storeLogin.getPassword(),
                true,
                session)
                .getRedirect();
    }

    @ModelAttribute("types")
    public List<ProductTypeE> productTypes() {
        var types = productTypeDao.findAllByActiveTrueOrderByIdAsc();
        return types;
    }
}