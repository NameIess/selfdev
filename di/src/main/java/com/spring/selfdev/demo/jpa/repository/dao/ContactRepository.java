package com.spring.selfdev.demo.jpa.repository.dao;


import com.spring.selfdev.demo.jpa.repository.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
