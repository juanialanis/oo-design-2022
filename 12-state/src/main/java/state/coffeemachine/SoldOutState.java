package state.coffeemachine;

public class SoldOutState extends State {
	CoffeeMachine machine;

	public SoldOutState(CoffeeMachine machine) {
		this.machine = machine;
	}

	public void refill() {
		machine.setState(new NoQuarterState(machine));
	}

	public String toString() {
		return "sold out";
	}
}
