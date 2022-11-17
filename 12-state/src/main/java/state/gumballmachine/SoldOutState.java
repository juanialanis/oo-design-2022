package state.gumballmachine;

public class SoldOutState extends State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void refill() {
		gumballMachine.setState(new NoQuarterState(gumballMachine));
	}

	public String toString() {
		return "sold out";
	}
}
