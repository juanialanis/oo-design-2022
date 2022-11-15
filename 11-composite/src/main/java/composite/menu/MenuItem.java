package composite.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class MenuItem extends MenuComponent {
 
	String name;
	String description;
	List<String> attributes;
	double price;
    
	public MenuItem(String name, 
	                String description, 
	                String[] attributes, 
	                double price) 
	{ 
		this.name = name;
		this.description = description;
		this.attributes = Arrays.asList(attributes);
		this.price = price;
	}
  
	public String getName() {
		return name;
	}
  
	public String getDescription() {
		return description;
	}
  
	public double getPrice() {
		return price;
	}
  
	public String[] getAttributes() {
		String[] result = (String[]) attributes.toArray();
    return result;
	}

	public Iterator<MenuComponent> createIterator() {
		return new NullIterator();
	}

  public boolean includeAttribute(String attributeName){
    return attributes.contains(attributeName);
  }
 
	public void print() {
		System.out.print("  " + getName());
		if (includeAttribute("vegetarian")){
			System.out.print("(v)");
		}
		System.out.println(", " + getPrice());
		System.out.println("     -- " + getDescription());
	}

}

