package remoteproccessing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
import remoteproccessing.entity.Contact;
import remoteproccessing.entity.Contacts;
import remoteproccessing.service.ContactService;

import java.util.List;

public class Runner {
    private static final Logger Log = LogManager.getLogger(Runner.class.getSimpleName());
    private static final String HTTP_ACTIVATOR_CONTEXT_XML = "classpath:/http-activator/http-invoker-app-context.xml";
    private static final String REST_TEMPLATE_CONTEXT_XML = "classpath:rest/restful-client-app-context.xml";
    private static final String URL_GET_ALL_CONTACTS = "http://localhost:8084/rest/contact/listdata";
    private static final String URL_UPDATE_CONTACT = "http://localhost:8084/rest/contact/{id}";
    private static final String URL_DELETE_CONTACT = "http://localhost:8084/rest/contact/{id}";
    private static final String URL_CREATE_CONTACT = "http://localhost:8084/rest/contact/";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(HTTP_ACTIVATOR_CONTEXT_XML);
        ctx.refresh();

//        runRestTemplate(ctx);


        runHttpActivator(ctx);

    }

    private static void runRestTemplate(GenericXmlApplicationContext ctx) {
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
        Log.info("Testing retrieve all contacts:");

//        Contact contactNew = new Contact();
//        contactNew.setFirstName("Dmity");
//        contactNew.setLastName("Nosko");
//        contactNew.setBirthDate(new DateTime());
//        contactNew = restTemplate.postForObject(URL_CREATE_CONTACT, contactNew, Contact.class);
//        Log.info("Just created: " + contactNew);
//        restTemplate.delete(URL_DELETE_CONTACT, 1L);

//        Contact underUpdate = restTemplate.getForObject(URL_UPDATE_CONTACT, Contact.class, 1);
//        underUpdate.setFirstName("Alex");
//        underUpdate.setLastName("Nosko");
//        restTemplate.put(URL_UPDATE_CONTACT, underUpdate, 1);
//
        Contacts contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
        listContacts(contacts);


    }

    private static void runHttpActivator(GenericXmlApplicationContext ctx) {
        ContactService contactService = ctx.getBean("remoteContactService", ContactService.class);

        Log.info("Finding all contacts");
        Contacts contacts = new Contacts();
        List<Contact> allContactList = contactService.findAll();
        contacts.setContactList(allContactList);
        listContacts(contacts);

        Log.info("Finding contact with first name = Chris");
        List<Contact> namedContactList = contactService.findAll();

        contacts.setContactList(namedContactList);
        listContacts(contacts);
    }

    private static void listContacts(Contacts contactList) {
        for (Contact contact : contactList.getContactList()) {
            Log.info(contact);
        }
    }
}
