//package com.spring.selfdev.demo.jpa.repository.entity;
//
//import com.google.common.collect.Lists;
//import com.spring.selfdev.demo.jpa.repository.dao.ContactAuditRepository;
//import com.spring.selfdev.demo.jpa.repository.service.ContactAuditService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service("contactAuditService")
//@Repository
//@Transactional
//public class ContactAuditServiceImpl implements ContactAuditService {
//    @Autowired
//    private ContactAuditRepository contactAuditRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<ContactAudit> findAll() {
//        return Lists.newArrayList(contactAuditRepository.findAll());
//    }
//
//    @Override
//    public Optional<ContactAudit> findById(Long id) {
//        return contactAuditRepository.findById(id);
//    }
//
//    @Override
//    public ContactAudit save(ContactAudit contactAudit) {
//        return contactAuditRepository.save(contactAudit);
//    }
//}
