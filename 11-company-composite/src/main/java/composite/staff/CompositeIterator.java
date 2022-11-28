package composite.staff;

import java.util.Iterator;
import java.util.Stack;
  
public class CompositeIterator implements Iterator<DeveloperComponent> {
	Stack<Iterator<DeveloperComponent>> stack = new Stack<Iterator<DeveloperComponent>>();
   
	public CompositeIterator(Iterator<DeveloperComponent> iterator) {
		stack.push(iterator);
	}
   
	public DeveloperComponent next() {
		if (hasNext()) {
			Iterator<DeveloperComponent> iterator = stack.peek();
			DeveloperComponent component = iterator.next();
			stack.push(component.createIterator());
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator<DeveloperComponent> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	/*
	 * No longer needed as of Java 8
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 *
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}


