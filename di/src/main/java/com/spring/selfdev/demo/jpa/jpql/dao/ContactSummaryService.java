package com.spring.selfdev.demo.jpa.jpql.dao;

import com.spring.selfdev.demo.jpa.jpql.entity.ContactSummary;

import java.util.List;

public interface ContactSummaryService {
    List<ContactSummary> findAll();
}
