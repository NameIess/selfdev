package remoteproccessing.dao;

import org.springframework.data.repository.CrudRepository;
import remoteproccessing.entity.Contact;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);
}
