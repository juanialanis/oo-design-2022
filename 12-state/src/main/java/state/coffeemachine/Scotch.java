package state.coffeemachine;

public class Scotch extends CondimentDecorator {
	public Scotch(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Scotch";
	}

	public int cost() {
		return 1 + beverage.cost();
	}
}
