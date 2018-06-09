//package remoteproccessing;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//import org.springframework.ui.ExtendedModelMap;
//import remoteproccessing.entity.Contact;
//import remoteproccessing.entity.Contacts;
//import remoteproccessing.service.ContactService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ContactControllerTest {
//    private final List<Contact> contactList = new ArrayList<>();
//    private ContactService contactService;
//    private ContactController contactController;
//    private Contact contact;
//
//    @Before
//    public void init() {
//        contact = new Contact();
//        contact.setId(1L);
//        contact.setFirstName("Alex");
//        contact.setLastName("Nosko");
//
//        contactList.add(contact);
//        contactService = Mockito.mock(ContactService.class);
//        contactController = new ContactController(contactService);
//    }
//
//    @Test
//    public void shouldReturnListWhenListIsNotEmpty() {
//        Mockito.when(contactService.findAll()).thenReturn(contactList);
//        ExtendedModelMap modelMap = new ExtendedModelMap();
//        modelMap.addAttribute("contacts", contactController.listData());
//
//        Contacts modelContacts = (Contacts) modelMap.get("contacts");
//
//        int expectedListSize = contactList.size();
//        int actualListSize = modelContacts.getContactList().size();
//
//
//        Assert.assertEquals(expectedListSize, actualListSize);
//    }
//
//    @Test
//    public void shouldCreateAndSaveEntityWhenEntityIsValid() {
//        Mockito.when(contactService.save(Mockito.any(Contact.class))).thenAnswer((Answer<Contact>) invocation -> {
//            contactList.add(contact);
//            return contact;
//        });
//
//        contactController.create(contact);
//        int expectedListSize = 2;
//        int actualListSize = contactList.size();
//
//        Assert.assertEquals(expectedListSize, actualListSize);
//    }
//}
