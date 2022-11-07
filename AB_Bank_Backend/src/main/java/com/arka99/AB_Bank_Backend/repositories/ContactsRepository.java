package com.arka99.AB_Bank_Backend.repositories;

import com.arka99.AB_Bank_Backend.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends CrudRepository<Contact,Long> {
}
