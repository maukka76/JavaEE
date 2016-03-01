/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@ComponentScan("com.base.service")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    @Qualifier(value="userDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            //http.headers().cacheControl().disable();
            //http.headers().defaultsDisabled();
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            filter.setEncoding("UTF-8");
            filter.setForceEncoding(true);
            http.addFilterBefore(filter,CsrfFilter.class);

            System.out.println("CONFIGURE HTTPSECURITY");
            
            http.authorizeRequests().antMatchers("/","/add").permitAll()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMIN')")
            .antMatchers("/student/**").access("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMIN')")        
            .and().formLogin()
            .defaultSuccessUrl("/admin/second")
            .loginPage("/login").failureUrl("/login/error")
            .usernameParameter("username")
            .passwordParameter("password").and()
            .logout().logoutSuccessUrl("/login?logout")
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/403");
    }   
}
