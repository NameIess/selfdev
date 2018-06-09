package com.spring.selfdev.demo.jpa.jpql.dao;

import com.spring.selfdev.demo.jpa.jpql.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);

    List<Contact> findAllByNativeQuery();

    List<Contact> findByCriteriaQuery(String firstName, String lastName);
}
