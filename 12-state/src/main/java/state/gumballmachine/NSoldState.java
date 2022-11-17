package state.gumballmachine;

public class NSoldState extends State {
	GumballMachine gumballMachine;
	int quarters;

	public NSoldState(GumballMachine gumballMachine, int quarters) {
		this.gumballMachine = gumballMachine;
		this.quarters = quarters;
	}

	public void dispense() {
		do {
			quarters--;
			gumballMachine.releaseBall();
		} while (gumballMachine.getCount() > 0 && quarters > 0);

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
