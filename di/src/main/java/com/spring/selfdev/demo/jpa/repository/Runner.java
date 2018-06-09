package com.spring.selfdev.demo.jpa.repository;

import com.spring.selfdev.demo.jpa.repository.entity.Contact;
import com.spring.selfdev.demo.jpa.repository.entity.Hobby;
import com.spring.selfdev.demo.jpa.repository.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Runner {

    private static final String ORM_CONTEXT = "classpath:/jpacontext/repository/app-context-annotation.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(ORM_CONTEXT);
        ctx.refresh();

        ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

        System.out.println("findAll ---------------------");
        printContacts(contactService.findAll());

        System.out.println("findByFirstName ---------------------");
        printContacts(contactService.findByFirstName("Chris"));

        System.out.println("findByFirstNameAndLastName ---------------------");
        printContacts(contactService.findByFirstNameAndLastName("Chris", "Schaefer"));

    }

    private static void printContacts(List<Contact> contactList) {
        System.out.println("\n\nListing contacts:");
        for (Contact contact : contactList) {
            System.out.println(contact);

//            if (contact.getContactTelDetailSet() != null) {
//                for (ContactTelDetail detail : contact.getContactTelDetailSet()) {
//                    System.out.println(detail);
//                }
//            }

            if (contact.getHobbySet() != null) {
                for (Hobby hobby : contact.getHobbySet()) {
                    System.out.println(hobby);
                }
            }
        }
    }
}
