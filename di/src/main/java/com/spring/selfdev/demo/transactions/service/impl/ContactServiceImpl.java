package com.spring.selfdev.demo.transactions.service.impl;

import com.google.common.collect.Lists;
import com.spring.selfdev.demo.transactions.dao.ContactRepository;
import com.spring.selfdev.demo.transactions.entity.Contact;
import com.spring.selfdev.demo.transactions.service.ContactService;
import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service("contactService")
@Repository
@Transactional      // Transaction will exist for each method of this class
public class ContactServiceImpl implements ContactService {
    private ContactRepository repository;
    private TransactionTemplate transactionTemplate;    // For programmatic transactions

    @PersistenceContext
    private EntityManager entityManager;    // For programmatic transactions

    @Autowired
    public void setRepository(ContactRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List<Contact> contactList = Lists.newArrayList(repository.findAll());
        return contactList;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
    public Optional<Contact> findById(Long id) {
        Optional<Contact> contact = repository.findById(id);
        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        Contact savedContact = repository.save(contact);
        return savedContact;
    }

//    @Override
//    @Transactional(readOnly = true, propagation = Propagation.NEVER)
//    public long countAll() {
//        Long contactAmount = repository.countAllContacts();
//        return contactAmount;
//    }

    public long countAll() {
        Long result = transactionTemplate.execute(transactionStatus ->
                entityManager.createNamedQuery("Contact.countAll", Long.class).getSingleResult());

        return result;
    }
}
