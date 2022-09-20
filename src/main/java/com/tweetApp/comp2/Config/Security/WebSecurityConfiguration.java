package com.tweetApp.comp2.Config.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1.0/tweets/register").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/login").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/{username}/forgot").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/add").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1.0/tweets/{username}/update/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1.0/tweets/{username}/like/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1.0/tweets/{username}/delete/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/**").permitAll()
                .anyRequest().authenticated();
    }
}