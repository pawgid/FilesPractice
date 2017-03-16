import model.Address;
import model.Company;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DataService;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DataServiceTest {

    private DataService dataService;
    private String xmlUser = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><User><login>kowalski</login><password>abc123</password></User>";
    private User userFromLoad;
    private User userXML;
    private Company company;

    public DataServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        dataService = new DataService();
        userXML = new User("kowalski", "abc123");
        company = new Company();

        company.setName("Biedronka");
        company.setAddress(new Address("ul. Cwiartki", "3", "4", "60-666", "Poznan", "Poland"));
        company.setNip("12345678");
//        company.setRegon("87654321");
//        company.setId("123");
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

    @Test
    public void printCompanyInfo() {
        List<String> companyInfo = dataService.printCompanyInfo(company);
        boolean resultAssert = true;
        resultAssert &= companyInfo.get(0).equals("Biedronka");
        System.out.println("resultAssert" + resultAssert);
        resultAssert &= companyInfo.get(1).equals("ul. Cwiartki 3/4\n60-666 Poznan");
        System.out.println("resultAssert" + resultAssert);
//        resultAssert &= companyInfo.get(2).equals("60-666 Poznan");
        for (String line : companyInfo) {
            System.out.println(line);
        }
        Assert.assertTrue(resultAssert);
    }
}
