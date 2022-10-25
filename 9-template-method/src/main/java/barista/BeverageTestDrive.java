package barista;

public class BeverageTestDrive {
	public static void main(String[] args) {
 
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
    BlackCoffee blackCoffee = new BlackCoffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

    System.out.println("\nMaking black coffee...");
		blackCoffee.prepareRecipe();
	}
}
