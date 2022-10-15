package decorator.starbuzz;

public class Scotch extends CondimentDecorator {
	public Scotch(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Scotch";
	}

	public double cost() {
		return .30 + beverage.cost();
	}
}
