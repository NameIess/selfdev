package com.spring.selfdev.demo.jpa.repository.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    private Set<ContactTelDetail> contactTelDetailSet = new HashSet<>();
    private Set<Hobby> hobbySet = new HashSet<>();

    public Contact() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetailSet() {
        return contactTelDetailSet;
    }

    public void setContactTelDetailSet(Set<ContactTelDetail> contactTelDetailSet) {
        this.contactTelDetailSet = contactTelDetailSet;
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail) {
        contactTelDetail.setContact(this);
        contactTelDetailSet.add(contactTelDetail);
    }

    public void removeContactTelDetail(ContactTelDetail contactTelDetail) {
        contactTelDetailSet.remove(contactTelDetail);
    }

    public void addHobby(Hobby hobby) {
        hobby.addContact(this);
        hobbySet.add(hobby);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    public Set<Hobby> getHobbySet() {
        return hobbySet;
    }

    public void setHobbySet(Set<Hobby> hobbySet) {
        this.hobbySet = hobbySet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", version=").append(version);
//        sb.append(", contactTelDetailSet=").append(contactTelDetailSet);
//        sb.append(", hobbySet=").append(hobbySet);
        sb.append('}');
        return sb.toString();
    }
}
