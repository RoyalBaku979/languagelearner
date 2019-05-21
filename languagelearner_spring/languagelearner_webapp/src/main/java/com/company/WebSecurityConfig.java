package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)//
                .passwordEncoder(passwordEncoder);
    }

    @Override//authentication authorization
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/logout**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/users").hasAnyAuthority("USER")
                .and()
                .authorizeRequests().antMatchers("/users/foo").hasAnyAuthority("USER","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/users/add").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().anyRequest().hasAnyAuthority("ADMIN")
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                    .logoutSuccessUrl("/login")
                    .permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/users")
                    .permitAll();
//                .and().csrf().disable();
    }//GET, POST



}