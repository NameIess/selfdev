package mvc.controller;

import mvc.entity.Contact;
import mvc.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/contacts")
@Controller
public class ContactController {
    private static final Logger Log = LogManager.getLogger(ContactController.class.getSimpleName());
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        Log.info("Listing contacts");

        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);

        Log.info("No of contacts: " + contacts.size());

        return "contacts/list";
    }
}
