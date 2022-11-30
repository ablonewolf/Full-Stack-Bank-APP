package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Loans;
import com.arka99.AB_Bank_Backend.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id)
    {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(id);
    }
}
