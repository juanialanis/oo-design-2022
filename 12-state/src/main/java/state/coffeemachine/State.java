package state.coffeemachine;

public abstract class State {

	public void insertQuarters(int n) {
		throw new UnsupportedOperationException("Cannot perform this operation: insertQuarter(int n)");
	}

	public void ejectQuarters() {
		throw new UnsupportedOperationException("Cannot perform this operation: ejectQuarters");
	}

	public void pressCoffeeButton(String coffee) {
		throw new UnsupportedOperationException("Cannot perform this operation: pressCoffeeButton");
	}

	public void pressCondimentButton(String condiment) {
		throw new UnsupportedOperationException("Cannot perform this operation: pressCondimentButton");
	}

	public void pressDispenseButton() {
		throw new UnsupportedOperationException("Cannot perform this operation: pressDispenseButton");
	}

	public void dispense() {
		throw new UnsupportedOperationException("Cannot perform this operation: dispense");
	}

	public void refill() {
		throw new UnsupportedOperationException("Cannot perform this operation: refill");
	}
}
