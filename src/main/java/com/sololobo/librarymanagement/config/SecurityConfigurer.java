package com.sololobo.librarymanagement.config;

import com.sololobo.librarymanagement.domain.enumeration.Role;
import com.sololobo.librarymanagement.security.CustomLoginSuccessHandler;
import com.sololobo.librarymanagement.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    CustomLoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests()
//                .antMatchers("/**").hasAnyRole(Role.STUDENT.name(), Role.FACULTY.name(), Role.ADMIN.name())
                .antMatchers("/static/**").permitAll()
                .antMatchers("/login", "/registration").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .successHandler(loginSuccessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/login");
    }
}
