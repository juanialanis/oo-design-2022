package state.coffeemachine;

public class CoffeeFactory {

    public Beverage createBeverage(String beverage) {

        if (beverage.equals("Dark Roast")) {
            return new DarkRoast();
        } else if (beverage.equals("Decaf")) {
            return new Decaf();
        } else if (beverage.equals("Espresso")) {
            return new Espresso();
        } else if (beverage.equals("House Blend")) {
            return new HouseBlend();
        }

        throw new IllegalArgumentException("Unknown coffee type");
    }

    public Beverage addCondiment(Beverage beverage, String condiment) {

        if (condiment.equals("Milk")) {
            return new Milk(beverage);
        } else if (condiment.equals("Mocha")) {
            return new Mocha(beverage);
        } else if (condiment.equals("Scotch")) {
            return new Scotch(beverage);
        } else if (condiment.equals("Soy")) {
            return new Soy(beverage);
        } else if (condiment.equals("Whip")) {
            return new Whip(beverage);
        }

        throw new IllegalArgumentException("Unknown condiment");
    }
}
