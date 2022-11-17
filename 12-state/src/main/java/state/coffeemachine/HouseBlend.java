package state.coffeemachine;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	public int cost() {
		return 1;
	}
}
