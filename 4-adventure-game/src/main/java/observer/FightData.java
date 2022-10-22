package observer;

import java.util.ArrayList;
import java.util.List;

public class FightData implements Subject{
  private List<Observer> observers;
	
	public FightData() {
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
