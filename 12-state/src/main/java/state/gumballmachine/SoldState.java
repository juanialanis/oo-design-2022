package state.gumballmachine;

public class SoldState extends State {
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(new NoQuarterState(gumballMachine));
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(new SoldOutState(gumballMachine));
		}
	}

	public void refill() {
	}

	public String toString() {
		return "dispensing a gumball";
	}
}
