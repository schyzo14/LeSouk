package com.miage.lesouk.securityComponents;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Configuration de Spring Security
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService myUserDetailsService() {
        return new AuthentificationService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.myUserDetailsService())
                .passwordEncoder(this.passwordEncoder())
                .and()
                .eraseCredentials(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {      
        http
            .httpBasic()
            .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
            .and()
            .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/", "/api/seConnecter", "/index.html", "/views/main.html", "/app.js", "/bower_components/**", "/templates/**", "/css/**").permitAll()
            .antMatchers("/api/utilisateurs/**", "/api/annonces/**").authenticated()
            .anyRequest().denyAll()
            .and()
            .rememberMe()
            .alwaysRemember(true);
        
    }

}
