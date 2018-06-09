package lazy;

import lazy.entity.Contact;
import lazy.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {
    private static final Logger Log = LogManager.getLogger(ContactController.class.getSimpleName());

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    public List<Contact> listData() {
        List<Contact> contactList = contactService.findAll();

        return contactList;
    }
}
