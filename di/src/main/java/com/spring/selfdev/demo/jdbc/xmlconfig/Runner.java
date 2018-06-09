package com.spring.selfdev.demo.jdbc.xmlconfig;

import com.spring.selfdev.demo.jdbc.xmlconfig.dao.ContactDao;
import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Runner {

    private static final String CONTEXT_XML = "classpath:/dbcontext/datasource-embedded.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(CONTEXT_XML);
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        System.out.println("First name for contact id 1 is: " +
                contactDao.findFirstNameById(1L));

        List<Contact> contactList = contactDao.findAll();
        printContact(contactList);

        List<Contact> contactListWithDetails = contactDao.findAllWithDetail();
        printContact(contactListWithDetails);
    }

    private static void printContact(List<Contact> contactList) {
        for (Contact c : contactList) {
            System.out.println("\n" + c);
        }
    }
}
