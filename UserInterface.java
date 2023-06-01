package machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final CoffeeMaker coffeeMaker;

    UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.coffeeMaker = new CoffeeMaker();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = this.scanner.nextLine();

            if (action.equals("exit")) {
                break;
            }

            if (!this.validateInputAction(action)) {
                System.out.println("Invalid action input: " + action + ", try again.");
                continue;
            }

            this.handleInputAction(action);
        }
    }

    private boolean validateInputAction(String inputAction) {
        return !inputAction.isBlank() && List.of("buy", "fill", "take", "remaining").contains(inputAction);
    }

    private void handleInputAction(String action) {
        switch (action.toLowerCase()) {
            case "buy" -> {
                int coffeeType = this.getCoffeeTypeChoice();
                if (coffeeType == -1) {
                    return;
                }

                if (coffeeType == 0) {
                    System.out.println("Right now we only have 3 types of coffee for you to buy: 1 - espresso, 2 - latte, 3 - cappuccino");
                    return;
                }

                switch (coffeeType) {
                    case 1 -> this.coffeeMaker.buy(new EspressoCoffee());
                    case 2 -> this.coffeeMaker.buy(new LatteCoffee());
                    case 3 -> this.coffeeMaker.buy(new CappuccinoCoffee());
                    default -> System.out.println("Invalid coffee type");
                }
            }
            case "fill" -> this.coffeeMaker.fill(this.getSupplies());
            case "take" -> this.coffeeMaker.take();
            case "remaining" -> {
                System.out.println();
                System.out.println(this.coffeeMaker);
                System.out.println();
            }
            default -> System.out.println("Invalid action input: " + action);
        }
    }

    private int getCoffeeTypeChoice() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        String input = this.scanner.nextLine();

        if (input.equals("back")) {
            return -1;
        }

        try {
            int coffeeType = Integer.parseInt(input);
            if (coffeeType < 1 || coffeeType > 3) {
                return 0;
            }

            return coffeeType;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Map<String, Integer> getSupplies() {
        Map<String, Integer> supplies = new HashMap<>();
        supplies.put("water", 0);
        supplies.put("milk", 0);
        supplies.put("coffeeBeans", 0);
        supplies.put("disposableCups", 0);

        System.out.println("Write how many ml of water you want to add:");
        if (this.scanner.hasNextInt()) {
            int supplyWaterAmount = this.scanner.nextInt();
            if (supplyWaterAmount > 0) {
                supplies.put("water", supplyWaterAmount);
            }
        }

        System.out.println("Write how many ml of milk you want to add:");
        if (this.scanner.hasNextInt()) {
            int supplyMilkAmount = this.scanner.nextInt();
            if (supplyMilkAmount > 0) {
                supplies.put("milk", supplyMilkAmount);
            }
        }

        System.out.println("Write how many grams of coffee beans you want to add:");
        if (this.scanner.hasNextInt()) {
            int supplyCoffeeBeansAmount = this.scanner.nextInt();
            if (supplyCoffeeBeansAmount > 0) {
                supplies.put("coffeeBeans", supplyCoffeeBeansAmount);
            }
        }

        System.out.println("Write how many disposable cups you want to add:");
        if (this.scanner.hasNextInt()) {
            int supplyDisposableCupsAmount = this.scanner.nextInt();
            if (supplyDisposableCupsAmount > 0) {
                supplies.put("disposableCups", supplyDisposableCupsAmount);
            }
        }

        this.scanner.nextLine();
        return supplies;
    }
}
