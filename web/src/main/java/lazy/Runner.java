package lazy;

import lazy.entity.Contact;
import lazy.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Runner {

    private static final String ORM_CONTEXT = "classpath:/lazycontext/lazy-context.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(ORM_CONTEXT);
        ctx.refresh();

        ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);

        System.out.println("findAll ---------------------");
        printContacts(contactService.findAll());

    }

    private static void printContacts(List<Contact> contactList) {
        System.out.println("\n\nListing contacts:");
        for (Contact contact : contactList) {
            System.out.println(contact);

//            System.out.println(contact.getContactTelDetailSet());
//            System.out.println(contact.getContactTelDetailSet().size());


//            if (contact.getContactTelDetailSet() != null) {
//                for (ContactTelDetail detail : contact.getContactTelDetailSet()) {
//                    System.out.println(detail);
//                }
//            }

        }
    }
}
