package pizzastore.factorymethod;

public class ArgentinePizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("muzza")) {
			return new ArgentineStyleMuzzaPizza();
		} else if (item.equals("especial")) {
			return new ArgentineStyleEspecialPizza();
		} else if (item.equals("fugazzetta")) {
			return new ArgentineStyleFugazzettaPizza();
		} else return null;
	}
}
