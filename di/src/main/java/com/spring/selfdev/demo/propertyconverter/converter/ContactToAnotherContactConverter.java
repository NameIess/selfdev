package com.spring.selfdev.demo.propertyconverter.converter;

import com.spring.selfdev.demo.propertyconverter.AnotherContact;
import com.spring.selfdev.demo.propertyconverter.Contact;
import org.springframework.core.convert.converter.Converter;

public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact> {

    @Override
    public AnotherContact convert(Contact contact) {
        AnotherContact anotherContact = new AnotherContact();
        anotherContact.setFirstName(contact.getFirstName());
        anotherContact.setLastName(contact.getLastName());
        anotherContact.setBirthDate(contact.getBirthDate());
        anotherContact.setPersonalSite(contact.getPersonalSite());

        return anotherContact;
    }
}
