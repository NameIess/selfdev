package com.spring.selfdev.demo.remoteproccessing.service.impl;

import com.google.common.collect.Lists;
import com.spring.selfdev.demo.remoteproccessing.dao.ContactRepository;
import com.spring.selfdev.demo.remoteproccessing.entity.Contact;
import com.spring.selfdev.demo.remoteproccessing.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional(readOnly = true)
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
    public Contact findById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        Contact contact = contactOptional.get();
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        Contact contactToSave = contactRepository.save(contact);
        return contactToSave;
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
