package machine;

import java.util.Map;

public class CoffeeMaker {
    private int waterAvailable;
    private int milkAvailable;
    private int coffeeBeansAvailable;
    private int noOfDisposableCups;
    private int income;

    CoffeeMaker() {
        this.waterAvailable = 400;
        this.milkAvailable = 540;
        this.coffeeBeansAvailable = 120;
        this.noOfDisposableCups = 9;

        this.income = 550;
    }

    public void buy(Coffee coffee) {
        if (!this.canPrepareCoffee(coffee)) {
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");
        this.income += coffee.getCost();
        this.waterAvailable -= coffee.getWaterPerCup();
        this.milkAvailable -= coffee.getMilkPerCup();
        this.coffeeBeansAvailable -= coffee.getCoffeeBeansPerCup();
        this.noOfDisposableCups--;
    }

    public void fill(Map<String, Integer> supplies) {
        this.waterAvailable += supplies.get("water");
        this.milkAvailable += supplies.get("milk");
        this.coffeeBeansAvailable += supplies.get("coffeeBeans");
        this.noOfDisposableCups += supplies.get("disposableCups");
    }

    public void take() {
        if (this.income == 0) {
            System.out.println("The machine has $0.");
            return;
        }

        System.out.println("I gave you " + this.income);
        this.income = 0;
    }

    private boolean canPrepareCoffee(Coffee coffee) {
        if (this.waterAvailable < coffee.getWaterPerCup()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (this.milkAvailable < coffee.getMilkPerCup()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (this.coffeeBeansAvailable < coffee.getCoffeeBeansPerCup()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (this.noOfDisposableCups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                this.waterAvailable + " ml of water\n" +
                this.milkAvailable + " ml of milk\n" +
                this.coffeeBeansAvailable + " g of coffee beans\n" +
                this.noOfDisposableCups + " disposable cups\n" +
                "$" + this.income + " of money";
    }
}
