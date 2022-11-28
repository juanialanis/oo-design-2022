package composite.staff;

import java.util.Iterator;

public abstract class DeveloperComponent {
   
	public void add(DeveloperComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(DeveloperComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public DeveloperComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
  
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getPosition() {
		throw new UnsupportedOperationException();
	}

	public abstract Iterator<DeveloperComponent> createIterator();
 
	public void print() {
		throw new UnsupportedOperationException();
	}
  
}
