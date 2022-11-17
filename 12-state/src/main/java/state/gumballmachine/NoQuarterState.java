package state.gumballmachine;

public class NoQuarterState extends State {
	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(new HasQuarterState(gumballMachine));
	}

	public void insertQuarter(int n) {
		System.out.println("You inserted " + n + " quarters");
		gumballMachine.setState(new HasNQuartersState(gumballMachine, n));
	}

	public void refill() {
	}

	public String toString() {
		return "waiting for quarter";
	}
}
