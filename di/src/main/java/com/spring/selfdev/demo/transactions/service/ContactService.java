package com.spring.selfdev.demo.transactions.service;

import com.spring.selfdev.demo.transactions.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();

    Optional<Contact> findById(Long id);

    Contact save(Contact contact);

    long countAll();
}
