package state.gumballmachine;

import java.util.Random;

public class HasQuarterState extends State {
	Random randomWinner = new Random(System.currentTimeMillis());
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(new NoQuarterState(gumballMachine));
	}

	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(new WinnerState(gumballMachine));
		} else {
			gumballMachine.setState(new SoldState(gumballMachine));
		}
	}

	public void refill() {
	}

	public String toString() {
		return "waiting for turn of crank";
	}
}
