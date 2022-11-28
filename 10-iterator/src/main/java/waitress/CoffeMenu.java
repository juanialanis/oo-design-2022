package waitress;

import java.util.ArrayList;
import java.util.Iterator;

public class CoffeMenu implements Menu {
	ArrayList<MenuItem> menuItems;
 
	public CoffeMenu() {
		menuItems = new ArrayList<MenuItem>();
    
		addItem("Latte", 
			"Classsic Latte Coffe", 
            false,
			4.99);
 
		addItem("Capucchinno", 
			"Italian recipe for the traditional capucchinno", 
			false,
			4.99);
 
		addItem("Mocha",
			"Latte coffe with chocolate topping",
			false,
			5.49);
	}

	public void addItem(String name, String description,
	                    boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
 
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
  
	public Iterator<MenuItem> createIterator() {
		return menuItems.iterator();
	}
}
