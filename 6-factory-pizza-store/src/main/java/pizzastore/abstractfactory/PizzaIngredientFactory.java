package pizzastore.abstractfactory;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
	public Especial[] createEspecial();
	public Muzza createMuzza();
	public Fugazzetta createFugazzetta();
 
}
