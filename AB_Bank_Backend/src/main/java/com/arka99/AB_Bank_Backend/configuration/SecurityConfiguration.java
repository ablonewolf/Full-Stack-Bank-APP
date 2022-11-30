package com.arka99.AB_Bank_Backend.configuration;

import com.arka99.AB_Bank_Backend.filter.*;
import com.arka99.AB_Bank_Backend.model.Authorities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        configuration.setAllowedMethods(Collections.singletonList("*"));
                        configuration.setAllowCredentials(true);
                        configuration.setAllowedHeaders(Collections.singletonList("*"));
                        configuration.setExposedHeaders(Arrays.asList("Authorization"));
                        configuration.setMaxAge(3600L);
                        return configuration;
                    }
                }).and()
                .csrf().ignoringAntMatchers("/contact","/register").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(new AuthenticationLoggingAtFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGenerationFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
//                .antMatchers("/myAccount").hasAuthority(Authorities.VIEWACCOUNT.name())
//                .antMatchers("/myBalance").hasAnyAuthority(Authorities.VIEWACCOUNT.name(),Authorities.VIEWBALANCE.name())
//                .antMatchers("/myLoans").hasAuthority(Authorities.VIEWLOANS.name())
//                .antMatchers("/myCards").hasAuthority(Authorities.VIEWCARDS.name())
                .antMatchers("/myAccount").hasRole("USER")
                .antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").hasRole("USER")
                .antMatchers("/user").authenticated()
                .antMatchers("/contact","/notices","/register").permitAll()
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
