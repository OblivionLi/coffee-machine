package machine;

public abstract class Coffee {
    private final int cost;
    private final int waterPerCup;
    private final int milkPerCup;
    private final int coffeeBeansPerCup;

    public Coffee(int cost, int waterPerCup, int milkPerCup, int coffeeBeansPerCup) {
        this.cost = cost;
        this.waterPerCup = waterPerCup;
        this.milkPerCup = milkPerCup;
        this.coffeeBeansPerCup = coffeeBeansPerCup;
    }

    public int getCost() {
        return this.cost;
    }

    public int getWaterPerCup() {
        return this.waterPerCup;
    }

    public int getMilkPerCup() {
        return this.milkPerCup;
    }

    public int getCoffeeBeansPerCup() {
        return this.coffeeBeansPerCup;
    }
}
