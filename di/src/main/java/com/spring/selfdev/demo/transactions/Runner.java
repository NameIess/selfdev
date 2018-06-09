package com.spring.selfdev.demo.transactions;

import com.spring.selfdev.demo.transactions.entity.Contact;
import com.spring.selfdev.demo.transactions.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Optional;

public class Runner {
    private static final String TRANSACTION_ANNOTATION_CONTEXT = "classpath:/transactionscontext/tx-annotation-app-context.xml";
    private static final String TRANSACTION_DECLARATIVE_CONTEXT = "classpath:/transactionscontext/tx-declarative-app-context.xml";
    private static final String TRANSACTION_PROGRAMMATIC_CONTEXT = "classpath:/transactionscontext/tx-programmatic-app-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(TRANSACTION_PROGRAMMATIC_CONTEXT);
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService", ContactService.class);
//        List<Contact> contactList = contactService.findAll();
//
//        for (Contact contact : contactList) {
//            System.out.println("\n" + contact);
//        }
//
//        Optional<Contact> foundedContact = contactService.findById(1L);
//        Contact contact = foundedContact.get();
//        contact.setFirstName("Alex");
//        contactService.save(contact);
//        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact amount: " + contactService.countAll());

    }
}
