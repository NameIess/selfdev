//package com.spring.selfdev.demo.jpa.repository.entity;
//
//
//import org.hibernate.local.Type;
//import org.joda.time.DateTime;
//import org.springframework.data.domain.Auditable;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.temporal.TemporalAccessor;
//import java.util.Date;
//
//@Entity
//@Table(name = "contact_audit")
//public class ContactAudit implements Auditable<String, Long>, Serializable {
//    private Long id;
//    private int version;
//    private String firstName;
//    private String lastName;
//    private Date birthDate;
//    private String createdBy;
//    private DateTime createdDate;
//    private String lastModifiedBy;
//    private DateTime lastModifiedDate;
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Version
//    @Column(name = "version")
//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }
//
//    @Column(name = "first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @Column(name = "last_name")
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "birth_date")
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    @Column(name = "created_by")
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    @Override
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    @Column(name = "created_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    public DateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(DateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    @Column(name = "last_modified_by")
//    public String getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    @Override
//    public void setLastModifiedBy(String lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    @Column(name = "last_modified_date")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    public DateTime getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(DateTime lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    @Transient
//    public boolean isNew() {
//        return id == null;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("ContactAudit{");
//        sb.append("id=").append(id);
//        sb.append(", version=").append(version);
//        sb.append(", firstName='").append(firstName).append('\'');
//        sb.append(", lastName='").append(lastName).append('\'');
//        sb.append(", birthDate=").append(birthDate);
//        sb.append(", createdBy='").append(createdBy).append('\'');
//        sb.append(", createdDate=").append(createdDate);
//        sb.append(", lastModifiedBy='").append(lastModifiedBy).append('\'');
//        sb.append(", lastModifiedDate=").append(lastModifiedDate);
//        sb.append('}');
//        return sb.toString();
//    }
//}
