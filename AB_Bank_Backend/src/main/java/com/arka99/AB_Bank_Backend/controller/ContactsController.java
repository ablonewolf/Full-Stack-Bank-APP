package com.arka99.AB_Bank_Backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
    @GetMapping("/contacts")
    public String getContactsDetails() {
        return "Here are the contacts details saved to the DB.";
    }
}
