package state.gumballmachine;

public class WinnerState extends State {
	GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(new SoldOutState(gumballMachine));
		} else {
			gumballMachine.releaseBall();
			System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(new NoQuarterState(gumballMachine));
			} else {
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(new SoldOutState(gumballMachine));
			}
		}
	}

	public void refill() {
	}

	public String toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
