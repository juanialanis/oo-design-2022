package composite.staff;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class DeveloperItem extends DeveloperComponent {
 
	String name;
	String position;
	List<String> attributes;
    
	public DeveloperItem(String name, 
	                String position) 
	{ 
		this.name = name;
		this.position = position;
	}
  
	public String getName() {
		return name;
	}
  
	public String getPosition() {
		return position;
	}
  
	public Iterator<DeveloperComponent> createIterator() {
		return new NullIterator();
	}
 
	public void print() {
		System.out.print("    " + getName());
		System.out.println(", " + getPosition());
	}

}

