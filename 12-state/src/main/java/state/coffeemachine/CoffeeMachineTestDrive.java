package state.coffeemachine;

public class CoffeeMachineTestDrive {

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(10);

        System.out.println(machine);
        machine.insertQuarters(3);
        machine.pressCoffeeButton("Dark Roast");
        machine.pressCondimentButton("Milk");
        machine.pressCondimentButton("Mocha");
        machine.pressDispenseButton();

        // TODO: whenver we pour a coffee, inventory only goes down by one (even if it
        // has condiments).
        // Make it such that the "capsule" count goes down proportionate to coffee +
        // condiments

        System.out.println(machine);

        machine.insertQuarters(2);
        machine.pressCoffeeButton("House Blend");
        machine.pressCondimentButton("Scotch");
        machine.pressDispenseButton();

        System.out.println(machine);

        machine.insertQuarters(1);
        machine.pressCoffeeButton("Decaf");
        machine.pressCondimentButton("Soy");
        machine.pressDispenseButton();
    }
}
