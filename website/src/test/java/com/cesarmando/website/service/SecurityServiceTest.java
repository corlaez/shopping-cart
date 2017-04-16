package com.cesarmando.website.service;

import com.cesarmando.website.MyApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by cvalverd on 15/04/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyApp.class})
public class SecurityServiceTest {

    @Autowired
    SecurityService securityService;

    @Test
    public void test_ml_always_return_true() {
        //assert correct type/impl
        assertThat(securityService, instanceOf(SecurityService.class));
        //assert true
        assertThat(securityService.getUserDao(), notNullValue());
    }

}
