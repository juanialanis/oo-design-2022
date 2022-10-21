package observer;

import java.util.*;

public class GameData implements Subject {
	private List<Observer> observers;
	private String characterAttackType;
	private String characterReceivesAttackType;
	private int damageReceived;
  private int life;
	
	public GameData() {
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
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(String cat, String crat, int damage, int life) {
		this.characterAttackType = cat;
		this.characterReceivesAttackType = crat;
		this.damageReceived = damage;
		this.life = life;
		measurementsChanged();
	}

	public String getCharacterAttackType() {
		return this.characterAttackType;
	}
	
	public String getCharacterReceivesAttackType() {
		return this.characterReceivesAttackType;
	}
	
	public int getDamageReceived() {
		return this.damageReceived;
	}

  public int getLife() {
		return this.life;
	}

}
