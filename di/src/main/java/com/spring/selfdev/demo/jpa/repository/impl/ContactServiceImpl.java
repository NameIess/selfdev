package com.spring.selfdev.demo.jpa.repository.impl;


import com.google.common.collect.Lists;
import com.spring.selfdev.demo.jpa.repository.dao.ContactRepository;
import com.spring.selfdev.demo.jpa.repository.entity.Contact;
import com.spring.selfdev.demo.jpa.repository.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        List<Contact> contactList = Lists.newArrayList(contactRepository.findAll());
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        List<Contact> contactList = contactRepository.findByFirstName(firstName);
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        List<Contact> contactList = contactRepository.findByFirstNameAndLastName(firstName, lastName);
        return contactList;
    }
}
