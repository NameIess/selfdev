package com.spring.selfdev.demo.jdbc.annotationconfig;

import com.spring.selfdev.demo.jdbc.xmlconfig.entity.Contact;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private StoredFunctionFirstNameById storedFunction;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.storedFunction = new StoredFunctionFirstNameById(dataSource);
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> stringList = storedFunction.execute(id);
        return stringList.get(0);
    }
}
