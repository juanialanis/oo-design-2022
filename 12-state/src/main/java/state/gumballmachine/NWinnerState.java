package state.gumballmachine;

public class NWinnerState extends State {
	GumballMachine gumballMachine;
	int quarters;

	public NWinnerState(GumballMachine gumballMachine, int quarters) {
		this.gumballMachine = gumballMachine;
		this.quarters = quarters;
	}

	public void dispense() {
		do {
			quarters--;
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() == 0) {
				gumballMachine.setState(new SoldOutState(gumballMachine));
			} else {
				gumballMachine.releaseBall();
				System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
			}
		} while (gumballMachine.getCount() > 0 && quarters > 0);

		if (gumballMachine.getCount() <= 0) {
			gumballMachine.setState(new SoldOutState(gumballMachine));
			return;
		}

		gumballMachine.setState(new NoQuarterState(gumballMachine));
	}

	public void refill() {
	}

	public String toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
