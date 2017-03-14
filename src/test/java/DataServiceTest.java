import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DataService;

import static org.junit.Assert.assertTrue;

public class DataServiceTest {

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;

    public DataServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
    }

    public void saveData() {
        dataService.saveData(xmlUser);
    }

    public void loadData() {
        userFromLoad = dataService.loadData();
    }

    @Test
    public void saveAndLoadData() {
        saveData();
        loadData();
        Assert.assertTrue(userFromLoad.equals(userXML));
    }
}
