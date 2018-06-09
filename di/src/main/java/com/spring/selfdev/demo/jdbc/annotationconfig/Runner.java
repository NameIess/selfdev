package com.spring.selfdev.demo.jdbc.annotationconfig;

import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Runner {

    private static final String DBCONTEXT_ANNOTAION = "classpath:/dbcontext/annotation-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(DBCONTEXT_ANNOTAION);
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contactList = contactDao.findAll();

        printContact(contactList);
    }

    private static void printContact(List<Contact> contactList) {
        for (Contact c : contactList) {
            System.out.println("\n" + c);
        }
    }
}
