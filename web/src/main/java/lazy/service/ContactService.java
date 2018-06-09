package lazy.service;

import lazy.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
