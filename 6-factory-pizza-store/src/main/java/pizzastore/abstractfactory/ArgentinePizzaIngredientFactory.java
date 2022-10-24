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

  public Onion createOnion() {
    return new Onion();
  }

  public Ham createHam() {
    return new Ham();
  }

  @Override
  public Pepperoni createPepperoni() {
    throw new UnsupportedOperationException("This ingredient is not available in this store.");
  }

  @Override
  public Clams createClam() {
    throw new UnsupportedOperationException("This ingredient is not available in this store.");
  }

}
