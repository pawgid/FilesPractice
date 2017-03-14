import model.User;
import service.DataService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        login(scanner);
//        DataService dataService = new DataService();
//        User user = ;
//        String xmlUser = ;
    }

    private static void login(Scanner scanner) {
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        User user = new User(login, password);

        UserService userService = new UserService();
        boolean isLogin = false;
        while (!isLogin) {
            if (isLogin = userService.authenticate(user)) {
                System.out.println("Zalogowany");
            } else {
                System.out.println("Nieprawidlowe haslo");
            }
        }
    }
}
