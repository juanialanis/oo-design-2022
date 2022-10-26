package pizzastore.abstractfactory;

public class EspecialPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public EspecialPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		meats = ingredientFactory.createMeat();
	}
}
