//package com.spring.selfdev.demo.hibernate.dao.impl;
//
//import com.spring.selfdev.demo.hibernate.dao.HobbyDao;
//import com.spring.selfdev.demo.hibernate.entity.Hobby;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Transactional
//@Repository("hobbyDao")
//public class HobbyDaoImpl implements HobbyDao {
//    private static final Logger Log = LogManager.getLogger(HobbyDaoImpl.class.getSimpleName());
//
//    private SessionFactory sessionFactory;
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    @Resource(name = "sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void save(Hobby hobby) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.saveOrUpdate(hobby);
//        Log.info("Hobby saved with id: " + hobby.getHobbyId());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Hobby> findAllWithDetail() {
//        Session currentSession = sessionFactory.getCurrentSession();
//        List hobbyList = currentSession.createQuery("FROM Hobby h").list();
//        return hobbyList;
//    }
//}
