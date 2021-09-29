package com.example.practice.config;

import com.example.practice.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Set your authentication configuration on the auth object.
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USERS")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("ADMIN");
//        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //Setting up authorization
        http.authorizeRequests()
                .antMatchers("/hello").permitAll()
                .antMatchers("/topics").authenticated()
                .antMatchers("/**").authenticated()
                .and().formLogin();
//                .antMatchers("/**").hasAnyRole("USER","ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //Specify the type of password encoded.
        return NoOpPasswordEncoder.getInstance();
    }
}
