package state.coffeemachine;

public class DispenseState extends State {
	CoffeeMachine machine;
	Beverage beverage;

	public DispenseState(CoffeeMachine machine) {
		this.machine = machine;
	}

	public void dispense() {
		if (machine.getStock() <= 0) {
			machine.setState(new SoldOutState(machine));
		}
		machine.releaseCoffee();
		machine.setState(new NoQuarterState(machine));
	}

	public void refill() {
	}

	public String toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
