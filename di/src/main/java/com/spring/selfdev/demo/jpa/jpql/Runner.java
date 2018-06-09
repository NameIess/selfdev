package com.spring.selfdev.demo.jpa.jpql;

import com.spring.selfdev.demo.jpa.jpql.dao.ContactService;
import com.spring.selfdev.demo.jpa.jpql.entity.Contact;
import com.spring.selfdev.demo.jpa.jpql.entity.ContactTelDetail;
import com.spring.selfdev.demo.jpa.jpql.entity.Hobby;
import com.spring.selfdev.demo.jpa.jpql.impl.ContactSummaryUntypeImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Runner {

    private static final String ORM_CONTEXT = "classpath:/jpacontext/jpql/app-context-annotation.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(ORM_CONTEXT);
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

//        printContacts(contactService.findAllWithDetail());
//        saveContactWithDetails(contactService);
//        updateContact(contactService);
//        printContacts(contactService.findAllWithDetail());
//        Contact contact = contactService.findById(1L);
//        System.out.println("FindById 1 = " + contact);
//        contactService.delete(contact);
//        printContacts(contactService.findAllWithDetail());

//        ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
//        contactSummaryUntype.displayAllContactSummary();

        printContacts(contactService.findAllByNativeQuery());   // LAZY NEEDED

//        printContacts(contactService.findByCriteriaQuery("John", "Smith"));
    }

    private static void printContacts(List<Contact> contactList) {
        System.out.println("\n\nListing contacts:");
        for (Contact contact : contactList) {
            System.out.println(contact);

            if (contact.getContactTelDetailSet() != null) {
                for (ContactTelDetail detail : contact.getContactTelDetailSet()) {
                    System.out.println(detail);
                }
            }

            if (contact.getHobbySet() != null) {
                for (Hobby hobby : contact.getHobbySet()) {
                    System.out.println(hobby);
                }
            }
        }
    }

    private static void saveContactWithDetails(ContactService contactService) {
        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());

        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);

        contactService.save(contact);
    }

    private static void updateContact(ContactService contactService) {
        Contact contact = contactService.findById(1L);
        contact.setFirstName("Alex Nosko");

        Set<ContactTelDetail> detailSet = contact.getContactTelDetailSet();
        ContactTelDetail toRemove = null;

        for (ContactTelDetail detail : detailSet) {
            if (detail.getTelType().equals("Home")) {
                toRemove = detail;
            }
        }
        contact.removeContactTelDetail(toRemove);

        contactService.save(contact);
    }

}
