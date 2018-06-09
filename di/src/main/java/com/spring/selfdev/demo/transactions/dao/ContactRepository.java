package com.spring.selfdev.demo.transactions.dao;

import com.spring.selfdev.demo.transactions.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("SELECT COUNT (c) FROM Contact c")
    Long countAllContacts();
}
