package com.tweetApp.comp2.Config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/register").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/forgot").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/{username}/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/add").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/reply/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/update").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/tweets/{username}/like/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1.0/tweets/{username}/delete/{id}").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/api/v1.0/tweets/{username}/delete/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/tweets/**").permitAll()
                .anyRequest().authenticated();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}