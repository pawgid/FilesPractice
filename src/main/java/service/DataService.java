package service;

import model.Company;
import model.User;
import org.apache.commons.io.FileUtils;
import xml.XMLFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class DataService {
    private File file;

    public DataService() {
        this.file = new File("C:\\Users\\RENT\\Desktop\\data\\data.dat");
    }

    public void saveData(String xmlString) {

        try {
            FileUtils.touch(file);
            FileUtils.writeStringToFile(file, xmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public User loadData() {
        User user = null;
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        String xml;
        try {
            xml = FileUtils.readFileToString(file, "UTF-8");
            user = xmlFactory.XMLToObject(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

   public List<String> printCompanyInfo(Company company) {
        List<String> result = new ArrayList<>();
        result.add(company.getName());
        result.add(company.getAddress().toString());
        result.add(String .valueOf(company.getId()));
        result.add(company.getNip());
        result.add(company.getRegon());


        return result;
   }

}
