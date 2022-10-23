package pizzastore.abstractfactory;

public class ArgentinePizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThickDough();
	}
 
	public Sauce createSauce() {
		return new TomatoSauce();
	}
 
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
 
	public Muzza createMuzza() {
		return new Muzza();
	}
 
	public Especial[] createEspecial() {
        Especial especial[] = { new Ham(), new BellPepper() };
		return especial;
	}

	public Fugazzetta createFugazzetta() {
		return new Fugazzetta();
	}
}
