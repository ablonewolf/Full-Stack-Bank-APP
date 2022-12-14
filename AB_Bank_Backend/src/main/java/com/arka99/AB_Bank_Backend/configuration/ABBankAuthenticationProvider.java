package com.arka99.AB_Bank_Backend.configuration;

import com.arka99.AB_Bank_Backend.model.Authority;
import com.arka99.AB_Bank_Backend.model.Customer;
import com.arka99.AB_Bank_Backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ABBankAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customers = customerRepository.findCustomerByEmail(username);
        if(customers.size()>0) {
            if(passwordEncoder.matches(password,customers.get(0).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username,password,getAuthorities(customers.get(0).getAuthorities()));
            }
            else {
                throw new BadCredentialsException("Invalid password");
            }
        }
        else {
            throw new BadCredentialsException("No user exists with this username");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    private List<GrantedAuthority> getAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        authorities.forEach(authority -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        });
        return grantedAuthorities;
    }
}
