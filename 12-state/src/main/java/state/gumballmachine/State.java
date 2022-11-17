package state.gumballmachine;

public abstract class State {

	public void insertQuarter() {
		throw new UnsupportedOperationException("Cannot perform this operation: insertQuarter");
	}

	public void insertQuarter(int n) {
		throw new UnsupportedOperationException("Cannot perform this operation: insertQuarter(int n)");
	}

	public void ejectQuarter() {
		throw new UnsupportedOperationException("Cannot perform this operation: ejectQuarter");
	}

	public void turnCrank() {
		throw new UnsupportedOperationException("Cannot perform this operation: turnCrank");
	}

	public void dispense() {
		throw new UnsupportedOperationException("Cannot perform this operation: dispense");
	}

	public void refill() {
		throw new UnsupportedOperationException("Cannot perform this operation: refill");
	}
}
