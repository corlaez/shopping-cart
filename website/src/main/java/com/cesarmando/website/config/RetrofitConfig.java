package com.cesarmando.website.config;

import com.cesarmando.website.adapter.restapi.GitHub.GitHubService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import javax.sql.DataSource;
import java.text.DateFormat;

/**
 * Raíz del proyecto y configuración básica
 * Created by jarma on 4/9/2017.
 */
@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .build();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                //.registerTypeAdapter(Id.class, new IdTypeAdapter())
                .enableComplexMapKeySerialization()
                //.serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setVersion(1.0)
                .create();
    }

    @Bean
    public GitHubService gitHubService(){
        return retrofit().create(GitHubService.class);
    }
}