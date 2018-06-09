package com.spring.selfdev.demo.jpa.jpql.impl;

import com.spring.selfdev.demo.jpa.jpql.dao.ContactSummaryService;
import com.spring.selfdev.demo.jpa.jpql.entity.ContactSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ContactSummary> findAll() {
        List<ContactSummary> result = entityManager.createQuery(
                "SELECT NEW com.spring.selfdev.demo.jpa.entity.ContactSummary( " +
                        "c.firstName, c.lastName, t.telNumber) " +
                        "FROM Contact c LEFT JOIN c.contactTelDetailSet t " +
                        "WHERE t.telType = 'Home'", ContactSummary.class

        ).getResultList();

        return result;
    }
}
