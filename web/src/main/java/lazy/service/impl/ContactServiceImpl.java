package lazy.service.impl;

import lazy.dao.ContactRepository;
import lazy.entity.Contact;
import lazy.service.ContactService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaContactService")
//@Transactional
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional
    public List<Contact> findAll() {
        List<Contact> contactList = contactRepository.findAll();
        contactList.forEach(System.out::println);

        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        List<Contact> contactList = contactRepository.findByFirstName(firstName);
        return contactList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        List<Contact> contactList = contactRepository.findByFirstNameAndLastName(firstName, lastName);
        return contactList;
    }
}
