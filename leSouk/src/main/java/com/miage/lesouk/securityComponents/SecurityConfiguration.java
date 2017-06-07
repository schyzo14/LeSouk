package com.miage.lesouk.securityComponents;

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

/**
 * Configuration de Spring Security
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Bean chargeant le service d'authentification
     * @return      User avec son pseudo, mdp et authorities
     */
    @Bean
    public UserDetailsService myUserDetailsService() {
        return new AuthentificationService();
    }

    /**
     * Bean chargeant le service de cryptage du mdp
     * @return      BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configuration de l'authentification
     * @param auth          AuthenticationManagerBuilder
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.myUserDetailsService())
                .passwordEncoder(this.passwordEncoder())
                .and()
                .eraseCredentials(true);
    }

    /**
     * Configuration de l'accès au serveur
     * @param http
     * @throws Exception 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {      
        http
            .httpBasic()
            .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
            .and()
            .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)     
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/", "/api/seConnecter").permitAll()
            .antMatchers("/api/utilisateurs/**", "/api/annonces/**").authenticated()
            .anyRequest().denyAll()
            .and()
            .rememberMe()
            .alwaysRemember(true);
    }
}
