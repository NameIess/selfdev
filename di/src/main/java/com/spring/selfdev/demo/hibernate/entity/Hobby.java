//package com.spring.selfdev.demo.hibernate.entity;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "hobby")
//public class Hobby implements Serializable {
//    private String hobbyId;
////    private Set<Contact> contactSet = new HashSet<>();
//
//    public Hobby() {
//    }
//
//    public Hobby(String hobbyId) {
//        this.hobbyId = hobbyId;
//    }
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @Column(name = "hobby_id")
//    public String getHobbyId() {
//        return hobbyId;
//    }
//
//    public void setHobbyId(String hobbyId) {
//        this.hobbyId = hobbyId;
//    }
//
////    @ManyToMany(fetch = FetchType.EAGER)
////    @JoinTable(name = "contact_hobby_detail",
////            joinColumns = @JoinColumn(name = "hobby_id"),
////            inverseJoinColumns = @JoinColumn(name = "contact_id"))
////    public Set<Contact> getContactSet() {
////        return contactSet;
////    }
////
////    public void setContactSet(Set<Contact> contactSet) {
////        this.contactSet = contactSet;
////    }
////
////    public void addContact(Contact contact) {
////        contactSet.add(contact);
////    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Hobby{");
//        sb.append("hobbyId='").append(hobbyId).append('\'');
////        sb.append(", contactSet=").append(contactSet);
//        sb.append('}');
//        return sb.toString();
//    }
//}