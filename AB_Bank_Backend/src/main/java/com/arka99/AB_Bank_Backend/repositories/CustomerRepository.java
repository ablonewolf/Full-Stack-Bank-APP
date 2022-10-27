package com.arka99.AB_Bank_Backend.repositories;

import com.arka99.AB_Bank_Backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findCustomerByEmail(String email);
}

