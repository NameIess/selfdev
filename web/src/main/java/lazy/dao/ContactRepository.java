package lazy.dao;


import lazy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

}
