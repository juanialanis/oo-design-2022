package composite.menu;

import java.util.Iterator;
  
public class Waitress {
	MenuComponent allMenus;
 
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
 
	public void printMenu() {
		allMenus.print();
	}
  
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				if (menuComponent.includeAttribute("vegetarian")) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}
		}
	}

  public void printDinnerMenu(){
		Iterator<MenuComponent> iterator = allMenus.createIterator();
    System.out.println("DINNER MENU");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				if (menuComponent.includeAttribute("dinner")) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {}
		}
  }
}
