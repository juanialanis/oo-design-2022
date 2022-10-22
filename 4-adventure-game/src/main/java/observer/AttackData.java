package observer;

import java.util.*;

public class AttackData implements Subject  {
	private List<Observer> observers;
	
	public AttackData() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
	public void attackDetailsChanged() {
		notifyObservers();
	}

}
