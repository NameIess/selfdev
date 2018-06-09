package mvc.service.impl;

import mvc.dao.ContactRepository;
import mvc.entity.Contact;
import mvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        Optional<Contact> contactOptional = contactRepository.findById(id);
        Contact contact = null;
        if (contactOptional.isPresent()) {
            contact = contactOptional.get();
        }

        return contact;
    }

    @Override
    public Contact save(Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }
}
