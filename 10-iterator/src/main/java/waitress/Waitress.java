package waitress;

import java.util.Iterator;
import java.util.List;
 
public class Waitress {
	List<Menu> allMenu;

	public Waitress(List<Menu> allMenu) {
		this.allMenu = allMenu;
	}
	
	// implicit iteration
	public void printMenu() {

		for (Menu menu : allMenu) {
			Iterator<MenuItem> items = menu.createIterator();
			while (items.hasNext()){
				printMenuItem(items.next());
			}
			System.out.println();
		}
	}
	

	public void deleteLastItemOfMenus() {

		for (Menu menu : allMenu) {
			Iterator<MenuItem> items = menu.createIterator();
			while (items.hasNext()){
				items.next();
			}
			items.remove();
		}
	}

	public void printMenuItem(MenuItem menuItem) {
		System.out.print(menuItem.getName() + ", ");
		System.out.print(menuItem.getPrice() + " -- ");
		System.out.println(menuItem.getDescription());
	}
}
