package composite.staff;

import java.util.ArrayList;
import java.util.Iterator;

public class Developer extends DeveloperComponent {
	Iterator<DeveloperComponent> iterator = null;
	ArrayList<DeveloperComponent> managedComponents = new ArrayList<DeveloperComponent>();
	String name;
	String position;
  
	public Developer(String name, String position) {
		this.name = name;
		this.position = position;
	}
 
	public void add(DeveloperComponent menuComponent) {
		managedComponents.add(menuComponent);
	}
 
	public void remove(DeveloperComponent menuComponent) {
		managedComponents.remove(menuComponent);
	}
 
	public DeveloperComponent getChild(int i) {
		return managedComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getPosition() {
		return position;
	}

  
	public Iterator<DeveloperComponent> createIterator() {
    iterator = new CompositeIterator(managedComponents.iterator());
		return iterator;
	}
 
 
	public void print() {
    System.out.print("\n");
    if(position.equals("MANAGER")){
      System.out.print("  ");
    }
		System.out.print(getName());
		System.out.println(", " + getPosition());
  
		Iterator<DeveloperComponent> iterator = managedComponents.iterator();
		while (iterator.hasNext()) {
			DeveloperComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}

}
