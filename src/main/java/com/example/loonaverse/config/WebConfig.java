package com.example.loonaverse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Value("#{'${security.cors.allowed-origins}'.split(',')}")
    private List<String> allowedOrigins;

    @Value("#{'${security.cors.allowed-methods}'.split(',')}")
    private List<String> allowedMethods;

    @Value("#{'${security.cors.allowed-headers}'.split(',')}")
    private List<String> allowedHeaders;

    @Value("${security.cors.allow-credentials}")
    private Boolean allowCredentials;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors(config -> config.configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOriginPatterns(this.allowedOrigins);
                    cors.setAllowedMethods(this.allowedMethods);
                    cors.setAllowedHeaders(this.allowedHeaders);
                    cors.setAllowCredentials(allowCredentials);
                    return cors;
                }))
                .authorizeRequests()
                .anyRequest().permitAll();
    }

}