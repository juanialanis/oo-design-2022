package pizzastore.factorymethod;

public class ArgentineStyleMuzzaPizza extends Pizza {

	public ArgentineStyleMuzzaPizza() { 
		name = "Argentine Style Muzza Pizza";
		dough = "Thick Crust Dough";
		sauce = "Tomato Sauce";
 
		toppings.add("Oregano");
		toppings.add("Olives");
	}
 
	void cut() {
		System.out.println("Cutting the pizza into slices");
	}
}
