package pizzastore.abstractfactory;

public class ArgentinePizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new ArgentinePizzaIngredientFactory();
 
		if (item.equals("muzza")) {
			pizza = new MuzzaPizza(ingredientFactory);
			pizza.setName("Argentine Style Muzza Pizza");
		} else if (item.equals("especial")) {
			pizza = new EspecialPizza(ingredientFactory);
			pizza.setName("Argentine Style Especial Pizza");
		} else if (item.equals("fugazzetta")) {
			pizza = new FugazzettaPizza(ingredientFactory);
			pizza.setName("Argentine Style Fugazzetta Pizza");
		}
		return pizza;
	}
}
