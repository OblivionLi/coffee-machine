package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        ui.displayMenu();
    }
}
