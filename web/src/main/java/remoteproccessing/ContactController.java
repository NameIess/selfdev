//package remoteproccessing;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import remoteproccessing.entity.Contact;
//import remoteproccessing.entity.Contacts;
//import remoteproccessing.service.ContactService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/contact")
//public class ContactController {
//    private static final Logger Log = LogManager.getLogger(ContactController.class.getSimpleName());
//
//    private ContactService contactService;
//
//    @Autowired
//    public ContactController(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
//    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
//    public Contacts listData() {
//        List<Contact> contactList = contactService.findAll();
//        Contacts contacts = new Contacts();
//        contacts.setContactList(contactList);
//
//        return contacts;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Contact findContactById(@PathVariable Long id) {
//        Contact contact = contactService.findById(id);
//
//        return contact;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Contact create(@RequestBody Contact contact) {
//        Log.info("Creating contact: " + contact);
//        contactService.save(contact);
//        Log.info("Contact created successfully: " + contact);
//
//        return contact;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public void update(@RequestBody Contact contact, @PathVariable Long id) {
//        Log.info("Updating contact: " + contact);
//        contactService.save(contact);
//        Log.info("Contact updated successfully: " + contact);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id) {
//        Log.info("Deleting contact with id: " + id);
//        Contact contact = contactService.findById(id);
//        contactService.delete(contact);
//        Log.info("Contact created successfully: " + contact);
//    }
//
//}
