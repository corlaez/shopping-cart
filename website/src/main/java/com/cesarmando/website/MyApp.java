package com.cesarmando.website;

import lombok.experimental.var;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Raíz del proyecto y configuración básica
 * Created by jarma on 4/9/2017.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({"com.cesarmando.website.*"})
@EntityScan("com.cesarmando.website.dao.model")
@EnableJpaRepositories("com.cesarmando.website.dao")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MyApp {

    public static void main(String[] args) throws Exception {
        SpringApplication sa = new SpringApplication();
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(MyApp.class, args);
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName("org.postgresql.Driver")
                .username("postgres")
                .password("cesarmando")//TODO crear una variable de env
                .url("jdbc:postgresql://localhost:5432/carrito")
                .build();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        var converter = new StringHttpMessageConverter();
        var supportedList = new ArrayList<>(converter.getSupportedMediaTypes());
        supportedList.add(new MediaType( MediaType.APPLICATION_JSON, Charset.forName("UTF-8")));
        converter.setSupportedMediaTypes(supportedList);
        return converter;
    }

}