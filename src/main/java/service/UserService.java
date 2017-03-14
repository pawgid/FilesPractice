package service;

import model.User;

public class UserService {

    public boolean authenticate(User user) {
        //pobieramy password z usera, gdy mamy wiecej niz jednego usera
        //pobieramy userFromFile czyli usera z pliku

        DataService dataService = new DataService();
        User userFromFile = dataService.loadData();

        return user.equals(userFromFile);
    }

}
