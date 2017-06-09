package com.cesarmando.website.dao;

import com.cesarmando.website.MyApp;
import lombok.experimental.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Local_admin on 6/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyApp.class})
public class ProductTypeDaoTest {
    public static String c1 = "Abrigos";
    public static String c2 = "Gorros";
    public static String c3 = "Mantas";
    public static String c4 = "Otros";

    //@Autowired
    //ProductTypeDao productTypeDao;

    @Test
    public void verifyTypesExist(){
    /*    var list = productTypeDao.findAll();
        assertTrue(list.contains(c1));
        assertTrue(list.contains(c2));
        assertTrue(list.contains(c3));
        assertTrue(list.contains(c4));*/
    }

}
