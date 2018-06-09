package mvc.service;

import mvc.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);
}
