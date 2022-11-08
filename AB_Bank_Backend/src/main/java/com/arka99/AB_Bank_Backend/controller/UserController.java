package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Customer;
import com.arka99.AB_Bank_Backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer customer1;
        ResponseEntity response = null;

        try{
            List<Customer> customers = (List<Customer>) customerRepository.findAll();
            if(!customers.contains(customer)) {
                String hashedPassword = passwordEncoder.encode(customer.getPassword());
                customer.setPassword(hashedPassword);
                customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
                customer1 = customerRepository.save(customer);
                if(customer1.getId()>0) {
                    response = ResponseEntity.status(HttpStatus.CREATED).body("Given user Details are successfully registered");
                }
            }
            else {
                response = ResponseEntity.status(HttpStatus.FORBIDDEN).body("This user already exists");
            }
        }
        catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred due to an internal server error");
        }
        return response;
    }
    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        customerRepository.findAll().forEach(System.out::println);
        return (List<Customer>) customerRepository.findAll();
    }
    @RequestMapping("/user")
    public Customer getUserDetails(Authentication authentication) {
        List<Customer> customers = customerRepository.findCustomerByEmail(authentication.getName());
        if(customers.size()>0) {
            return customers.get(0);
        }
        else {
            return null;
        }
    }
}
