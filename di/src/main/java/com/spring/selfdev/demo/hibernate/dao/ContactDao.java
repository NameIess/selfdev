package com.spring.selfdev.demo.hibernate.dao;

import com.spring.selfdev.demo.hibernate.entity.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
