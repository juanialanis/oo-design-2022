package state.gumballmachine;

import java.util.Random;

public class HasNQuartersState extends State {
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;
	int quarters;

	public HasNQuartersState(GumballMachine gumballMachine, int quarters) {
		this.gumballMachine = gumballMachine;
		this.quarters = quarters;
	}

	public void ejectQuarter() {
		System.out.println(quarters + "quarters returned");
		gumballMachine.setState(new NoQuarterState(gumballMachine));
	}

	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(new NWinnerState(gumballMachine, quarters));
		} else {
			gumballMachine.setState(new NSoldState(gumballMachine, quarters));
		}
	}

	public void refill() {
	}

	public String toString() {
		return "waiting for turn of crank";
	}
}
