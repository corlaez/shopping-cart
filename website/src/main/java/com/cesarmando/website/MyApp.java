package com.cesarmando.website;

import com.google.gson.Gson;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import javax.sql.DataSource;

/**
 * Raíz del proyecto y configuración básica
 * Created by jarma on 4/9/2017.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, JacksonAutoConfiguration.class})
@ComponentScan({"com.cesarmando.website.*"})
@EntityScan("com.cesarmando.website.dao.model")
@EnableJpaRepositories("com.cesarmando.website.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyApp {

    public static void main(String[] args) throws Exception {
        SpringApplication sa = new SpringApplication(MyApp.class);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(args);
    }//https://www.mkyong.com/spring/spring-profiles-example/

    @Bean
    @Profile("postgre")
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
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }

}