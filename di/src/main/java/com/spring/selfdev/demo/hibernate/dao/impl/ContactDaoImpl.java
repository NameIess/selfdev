package com.spring.selfdev.demo.hibernate.dao.impl;

import com.spring.selfdev.demo.hibernate.dao.ContactDao;
import com.spring.selfdev.demo.hibernate.entity.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
    private static final Logger Log = LogManager.getLogger(ContactDaoImpl.class.getSimpleName());
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        List contactList = currentSession.createQuery("FROM Contact c").list();
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        Session currentSession = sessionFactory.getCurrentSession();
        List contactList = currentSession.getNamedQuery("Contact.findAllWithDetail").list();
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Object contact = currentSession.getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
        return (Contact) contact;
    }

    @Override
    public Contact save(Contact contact) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(contact);
        Log.info("Contact saved with id: " + contact.getId());
        return null;
    }

    @Override
    public void delete(Contact contact) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(contact);
        Log.info("Contact deleted with id: " + contact.getId());
    }
}
