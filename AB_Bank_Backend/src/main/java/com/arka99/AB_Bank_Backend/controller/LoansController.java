package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Loans;
import com.arka99.AB_Bank_Backend.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;
    @GetMapping("/myloans")
    public List<Loans> getLoanDetails(@RequestParam int id)
    {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(id);
        return loans;
    }
}
