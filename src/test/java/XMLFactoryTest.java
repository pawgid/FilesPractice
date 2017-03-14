import junit.framework.TestCase;
import model.User;
import org.junit.Before;
import org.junit.Test;
import xml.XMLFactory;

import javax.xml.stream.XMLStreamException;

import static org.junit.Assert.assertTrue;

public class XMLFactoryTest {
    private String login;
    private String password;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";

    public XMLFactoryTest() {
    }

    @Before
    public void setUp() throws Exception {
        login = "kowalski";
        password = "abc123";

    }

    @Test
    public void objectToXML() {
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User user = new User(login, password);
        String xmlUser2 = xmlFactory.objectToXML(user);
        System.out.println(xmlUser2);
//        assertTrue(true);
        assertTrue(xmlUser2.equals(xmlUser));
    }

    @Test
    public void xmlToObject() {
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        User UserFromXml = null;
        UserFromXml = xmlFactory.XMLToObject(xmlUser);
        User user = new User(login, password);
//        System.out.println(xmlUser);
//        assertTrue(true);
        assertTrue(user.equals(UserFromXml));
    }
}
