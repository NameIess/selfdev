package com.spring.selfdev.demo.jpa.jpql.impl;

import com.spring.selfdev.demo.jpa.jpql.dao.ContactService;
import com.spring.selfdev.demo.jpa.jpql.entity.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    private static final Logger Log = LogManager.getLogger(ContactServiceImpl.class.getSimpleName());
    private static final String ALL_CONTACT_NATIVE_QUERY = "SELECT id, first_name, last_name, birth_date, version FROM contact";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List contactList = entityManager.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        List contactList = entityManager.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = entityManager.createNamedQuery("Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            Log.info("Inserting new contact");
            entityManager.persist(contact);
        } else {
            Log.info("Updating existing contact");
            entityManager.merge(contact);
        }

        Log.info("Contact saved with id: " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        Contact mergedContact = entityManager.merge(contact);
        entityManager.remove(mergedContact);
        Log.info("Contact deleted with id: " + contact.getId());
    }

    @Override
    public List<Contact> findAllByNativeQuery() {
        List resultList = entityManager.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
//        Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
//        contactRoot.fetch(Contact_.contactTelDetailSet, JoinType.LEFT);
//        contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
//        criteriaQuery.select(contactRoot).distinct(true);
//        Predicate criteria = cb.conjunction();
//        if (firstName != null) {
//            Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
//            criteria = cb.and(criteria, p);
//        }
//        if (lastName != null) {
//            Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
//            criteria = cb.and(criteria, p);
//        }
//
//        criteriaQuery.where(criteria);
//        return entityManager.createQuery(criteriaQuery).getResultList();
        return null;
    }
}
