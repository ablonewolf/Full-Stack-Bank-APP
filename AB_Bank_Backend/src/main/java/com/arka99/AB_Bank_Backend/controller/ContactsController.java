package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Contact;
import com.arka99.AB_Bank_Backend.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactsController {

    @Autowired
    private ContactsRepository contactsRepository;
    @PostMapping ("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactsRepository.save(contact);
    }
    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }
}
