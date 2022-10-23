package pizzastore.abstractfactory;

public class FugazzettaPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
 
	public FugazzettaPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
 
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		fugazzetta = ingredientFactory.createFugazzetta();
	}
}
