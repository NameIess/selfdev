package com.spring.selfdev.demo.jdbc.xmlconfig.dao.impl;

import com.spring.selfdev.demo.jdbc.xmlconfig.dao.ContactDao;
import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;
import com.spring.selfdev.demo.jdbc.xmlconfig.entity.ContactDetail;
import com.spring.selfdev.demo.jdbc.xmlconfig.exception.MySQLErrorCodeTranslator;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcContactDao implements ContactDao, InitializingBean {
    private static final String SELECT_FIRST_NAME_BY_ID = "SELECT first_name FROM contact WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, first_name, last_name, birth_date FROM contact";
    private static final String FIND_ALL_WITH_DETAIL = "select c.id, c.first_name, c.last_name, c.birth_date" +
            ", t.id as contact_tel_id, t.tel_type, t.tel_number from contact c " +
            "left join contact_tel_detail t on c.id = t.contact_id";
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        MySQLErrorCodeTranslator errorTranslator = new MySQLErrorCodeTranslator();
        errorTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(errorTranslator);
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactService");
        }

        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on ContactService");
        }
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_FIRST_NAME_BY_ID,
                new Object[]{id}, String.class);
    }

    @Override
    public List<Contact> findAll() {
        return namedParameterJdbcTemplate.query(FIND_ALL, (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setBirthDate(rs.getDate("birth_date"));

            return contact;
        });
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return namedParameterJdbcTemplate.query(FIND_ALL_WITH_DETAIL, (ResultSet rs) -> {
            Map<Long, Contact> map = new HashMap<>();
            Contact contact;
            while (rs.next()) {
                Long id = rs.getLong("id");
                contact = map.get(id);
                if (contact == null) {
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setBirthDate(rs.getDate("birth_date"));
                    contact.setContactDetailList(new ArrayList<>());
                    map.put(id, contact);
                }

                Long contactTelDetailId = rs.getLong("contact_tel_id");
                if (contactTelDetailId > 0) {
                    ContactDetail contactTelDetail = new ContactDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(rs.getString("tel_type"));
                    contactTelDetail.setTelNumber(rs.getString("tel_number"));
                    contact.getContactDetailList().add(contactTelDetail);
                }
            }
            return new ArrayList<>(map.values());
        });
    }
}
