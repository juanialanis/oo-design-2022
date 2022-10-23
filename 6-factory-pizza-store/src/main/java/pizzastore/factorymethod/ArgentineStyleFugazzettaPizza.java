package pizzastore.factorymethod;

public class ArgentineStyleFugazzettaPizza extends Pizza {

	public ArgentineStyleFugazzettaPizza() { 
		name = "Argentine Style Fugazzetta Pizza";
		dough = "Thick Dough";
		sauce = "Tomato Sauce";
 
		toppings.add("Oregano");
		toppings.add("Chopped Onions");
		toppings.add("Olives");
	}
 
	void cut() {
		System.out.println("Cutting the pizza into slices");
	}
}
