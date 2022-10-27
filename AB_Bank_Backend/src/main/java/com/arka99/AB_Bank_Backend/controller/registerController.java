package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Customer;
import com.arka99.AB_Bank_Backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class registerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer customer1 = null;
        ResponseEntity response = null;

        try{
            List<Customer> customers = customerRepository.findAll();
            if(!customers.contains(customer)) {
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
        return customerRepository.findAll();
    }
}
