package com.spring.selfdev.demo.hibernate;

import com.spring.selfdev.demo.hibernate.dao.ContactDao;
import com.spring.selfdev.demo.hibernate.entity.Contact;
import com.spring.selfdev.demo.hibernate.entity.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Runner {

    private static final String ORM_CONTEXT = "classpath:/hibernatecontext/hibernate-context-annotation.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(ORM_CONTEXT);
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);

        printContacts(contactDao.findAll());
//        saveContactWithDetails(contactDao);
//        printContacts(contactDao.findAllWithDetail());
//        updateContact(contactDao);
//        printContacts(contactDao.findAllWithDetail());
//        Contact contact = contactDao.findById(1L);
//        System.out.println("FindById 1 = " + contact);
//        contactDao.delete(contact);
//        printContacts(contactDao.findAllWithDetail());

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

//            if (contact.getHobbySet() != null) {
//                for (Hobby hobby : contact.getHobbySet()) {
//                    System.out.println(hobby);
//                }
//            }
        }
    }

    private static void saveContactWithDetails(ContactDao contactDao) {
        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());

        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "1111111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
        contact.addContactTelDetail(contactTelDetail);

        contactDao.save(contact);
    }

    private static void updateContact(ContactDao contactDao) {
        Contact contact = contactDao.findById(1L);
        contact.setFirstName("Alex Nosko");

        Set<ContactTelDetail> detailSet = contact.getContactTelDetailSet();
        ContactTelDetail toRemove = null;

        for (ContactTelDetail detail : detailSet) {
            if (detail.getTelType().equals("Home")) {
                toRemove = detail;
            }
        }
        contact.removeContactTelDetail(toRemove);

        contactDao.save(contact);
    }

}
