package com.cesarmando.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jarma on 7/31/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private Environment environment;

  @Value("${custom.httpToHttps}")
  private Boolean httpToHttps;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // other security configuration missing
    if(httpToHttps) {
      http.requiresChannel().anyRequest().requiresSecure();
      http.portMapper()
          .http(Integer.parseInt(
              environment.getProperty("server.http.port")))
          .mapsTo(Integer.parseInt(
              environment.getProperty("server.port")));
    }
  }
}