package com.spring.selfdev.demo.jdbc.xmlconfig.dao;

import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> findAll();

    List<Contact> findAllWithDetail();

//    List<Contact> findByFirstName(String firstName);

//    String findLastNameById(Long id);

    String findFirstNameById(Long id);

//    void insert(Contact contact);
//
//    void update(Contact contact);
//
//    void delete(Long contactId);
}
