package com.spring.selfdev.demo.jpa.jpql.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryUntypeImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public void displayAllContactSummary() {
        List result = entityManager
                .createQuery("SELECT c.firstName, c.lastName, t.telNumber "
                        + " FROM Contact c LEFT JOIN c.contactTelDetailSet t "
                        + " WHERE t.telType = 'Home'").getResultList();
        int count = 0;
        for (Iterator i = result.iterator(); i.hasNext();) {
            Object[] values = (Object[]) i.next();
            System.out.println("contactTelDetailSet: " +  ++count + " row: " + values[0] + ", " + values[1] + ", " + values[2]);
        }
    }
}
