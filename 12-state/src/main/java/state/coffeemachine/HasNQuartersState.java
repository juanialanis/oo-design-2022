package state.coffeemachine;

public class HasNQuartersState extends State {

	CoffeeFactory factory = new CoffeeFactory();
	CoffeeMachine machine;
	int spent = 0;
	int quarters;

	public HasNQuartersState(CoffeeMachine machine, int quarters) {
		this.machine = machine;
		this.quarters = quarters;
	}

	public void ejectQuarters() {
		System.out.println(quarters + " quarters ejected!");
		machine.setState(new NoQuarterState(machine));
	}

	public void pressCoffeeButton(String coffee) {
		System.out.println("You pressed the " + coffee + " button");
		if (spent >= quarters) {
			System.out.println("Not enough quarters for this coffee");
			this.ejectQuarters();
		}

		machine.beverage = factory.createBeverage(coffee);
		spent = machine.beverage.cost();
	}

	public void pressCondimentButton(String condiment) {
		System.out.println("You pressed the " + condiment + " button");
		if (spent >= quarters) {
			System.out.println("Not enough quarters for this coffee");
			this.ejectQuarters();
		}
		machine.beverage = factory.addCondiment(machine.beverage, condiment);
		spent = machine.beverage.cost();
	}

	public void pressDispenseButton() {
		System.out.println("You pressed the dispense button");
		machine.setState(new DispenseState(machine));
	}

	public void refill() {
	}

	public String toString() {
		return "selecting coffee";
	}
}
