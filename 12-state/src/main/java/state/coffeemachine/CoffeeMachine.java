package state.coffeemachine;

public class CoffeeMachine {

    State state = new SoldOutState(this);
    Beverage beverage;
    int count;

    public CoffeeMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = new NoQuarterState(this);
        }
    }

    public void insertQuarters(int n) {
        try {
            state.insertQuarters(n);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void pressCoffeeButton(String coffee) {
        try {
            state.pressCoffeeButton(coffee);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void pressCondimentButton(String condiment) {
        try {
            state.pressCondimentButton(condiment);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void pressDispenseButton() {
        try {
            state.pressDispenseButton();
            state.dispense();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseCoffee() {
        System.out.println("Pouring coffee: " + this.beverage.getDescription() + "!");
        if (count > 0) {
            count = count - 1;
        }
    }

    int getStock() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The coffee machine was just refilled; its new count is: " + this.count);
        state.refill();
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nStarbuzz Coffee, Inc.");
        result.append("\nJava-enabled Coffee Dispenser Model #2004");
        result.append("\nInventory: " + count + " capsule");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
