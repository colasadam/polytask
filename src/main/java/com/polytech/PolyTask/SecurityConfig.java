package com.polytech.PolyTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication().dataSource(datasource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //mettre avant le authenticated() toutes les pages qui n'ont pas besoin d'authentifiaction
        //ceux qui n'ont pas besoin d'authentification pas besoin de les déclarer
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/register.html").permitAll()
                .mvcMatchers("/test_users").permitAll()
                .anyRequest().authenticated()
                .mvcMatchers("/admin/*").hasRole("ADMIN")
                .mvcMatchers("/about","help","register").permitAll()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}

