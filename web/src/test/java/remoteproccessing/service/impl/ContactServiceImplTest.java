package remoteproccessing.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import remoteproccessing.entity.Contact;
import remoteproccessing.service.ContactService;
import util.DataSets;
import util.ServiceTestConfig;
import util.ServiceTestExecutionListener;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ContactService contactService;


    @DataSets(setUpDataSet = "/data/ContactServiceImplTest.xls")
    @Test
    public void shouldReturnListWhenListIsNotEmpty() {
        List<Contact> contactList = contactService.findAll();

        Assert.assertNotNull(contactList);
        Assert.assertEquals(1, contactList.size());
    }
}
