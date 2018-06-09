package com.spring.selfdev.demo.jpa.jpql.dao;

import com.spring.selfdev.demo.jpa.jpql.entity.Hobby;

import java.util.List;

public interface HobbyService {
    void save(Hobby hobby);

    List<Hobby> findAllWithDetail();
}
