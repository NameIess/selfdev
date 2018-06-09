package remoteproccessing.entity;

import java.io.Serializable;
import java.util.List;

public class Contacts implements Serializable {

    private List<Contact> contactList;

    public Contacts() {
    }

    public Contacts(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}
