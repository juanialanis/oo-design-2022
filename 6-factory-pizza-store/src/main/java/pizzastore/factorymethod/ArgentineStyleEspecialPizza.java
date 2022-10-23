package pizzastore.factorymethod;

public class ArgentineStyleEspecialPizza extends Pizza {

	public ArgentineStyleEspecialPizza() { 
		name = "Argentine Style Especial Pizza";
		dough = "Thick Dough";
		sauce = "Tomato Sauce";
 
		toppings.add("Ham");
		toppings.add("Bell Pepper");
		toppings.add("Olives");
	}
 
	void cut() {
		System.out.println("Cutting the pizza into slices");
	}
}
