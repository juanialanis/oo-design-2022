package pizzastore.abstractfactory;

public class ForTestingPurposesPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public ForTestingPurposesPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
	}
}
