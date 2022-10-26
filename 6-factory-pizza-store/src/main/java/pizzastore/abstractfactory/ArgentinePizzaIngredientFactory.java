package pizzastore.abstractfactory;

public class ArgentinePizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThickCrustDough();
	}
 
	public Sauce createSauce() {
		return new TomatoSauce();
	}
 
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Onion(), new RedPepper() };
		return veggies;
	}
  
  public Meat[] createMeat() {
    Meat[] meats = { new Ham() };
    return meats;
  }

}
