package com.arka99.AB_Bank_Backend.configuration;

import com.arka99.AB_Bank_Backend.model.Customer;
import com.arka99.AB_Bank_Backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ABBankUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password;
        List<GrantedAuthority> authorities;
        List<Customer> customers = customerRepository.findCustomerByEmail(username);
        if(customers.isEmpty()) {
            throw new UsernameNotFoundException("User with this email does not exist");
        }
        else {
            userName = customers.get(0).getEmail();
            password = customers.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }
        return new User(username,password,authorities);
    }
}
