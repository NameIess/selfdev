package com.spring.selfdev.demo.jdbc.annotationconfig;

import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.lang.Nullable;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static final String FIND_ALL = "SELECT id, first_name, last_name, birth_date FROM contact";

    public SelectAllContacts(DataSource ds) {
        super(ds, FIND_ALL);
    }

    @Nullable
    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthDate(resultSet.getDate("birth_date"));
        return contact;
    }
}
