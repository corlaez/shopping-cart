package com.cesarmando.website.controller;

import com.cesarmando.website.MyApp;
import com.cesarmando.website.service.SecurityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by cvalverd on 15/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyApp.class})
public class HomeControllerTest {

    @Test
    public void test_ml_always_return_true() {

    }

}
