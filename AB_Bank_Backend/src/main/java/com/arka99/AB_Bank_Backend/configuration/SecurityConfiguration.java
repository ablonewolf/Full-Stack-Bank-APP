package com.arka99.AB_Bank_Backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/myAccount","/myBalance","/myLoans","/myCards","/user","/getCustomers").authenticated()
                .antMatchers("/contacts","/notices","/register").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return httpSecurity.build();

//        denying all requests to any services

//        httpSecurity.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();
//        return httpSecurity.build();

//        allowing any request to all microservices without any authorization
//        httpSecurity.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
//        return httpSecurity.build();

    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
////        using the InMemoryUserDetailsManager with default password encoder
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("12345")
////                .authorities("admin")
////                .build();
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("12345")
////                .authorities("user")
////                .build();
////        return new InMemoryUserDetailsManager(admin,user);
//
////        Using the InMemoryUserDetailsManager with a separate Bean of PasswordEncoder
//        UserDetails admin = User.withUsername("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password("12345")
//                .authorities("user")
//                .build();
//        return new InMemoryUserDetailsManager(admin,user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    Using a bean of BcryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
