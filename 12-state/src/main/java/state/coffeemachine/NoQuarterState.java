package state.coffeemachine;

public class NoQuarterState extends State {
	CoffeeMachine machine;

	public NoQuarterState(CoffeeMachine machine) {
		this.machine = machine;
	}

	public void insertQuarters(int n) {
		System.out.println("You inserted " + n + " quarters");
		machine.setState(new HasNQuartersState(machine, n));
	}

	public void refill() {
	}

	public String toString() {
		return "waiting for quarter";
	}
}
