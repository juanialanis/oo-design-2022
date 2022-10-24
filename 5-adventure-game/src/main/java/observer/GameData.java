package observer;

import java.util.ArrayList;
import java.util.List;

import game.Character;

public class GameData {
  private String attackerType;
  private String attackerWeaponType;
  private String attackeeType;
  private String attackeeWeaponType;
  private int attackerLife;
  private int attackeeLife;
  private int attackerWeaponDamage;
  private int attackeeWeaponDamage;
  private String fightStatus;
  private List<Observer> observers;

  public GameData(){
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
	
	public void detailsChanged() {
		notifyObservers();
	}

  public String getAttackerType() {
		return this.attackerType;
	}
	
	public String getAttackeeType() {
		return this.attackeeType;
	}

  public String getAttackerWeaponType() {
		return this.attackerWeaponType;
	}
	
	public String getAttackeeWeaponType() {
		return this.attackeeWeaponType;
	}

  public int getAttackerWeaponDamage() {
		return this.attackerWeaponDamage;
	}
	
	public int getAttackeeWeaponDamage() {
		return this.attackeeWeaponDamage;
	}

  public int getAttackerLife() {
		return this.attackerLife;
	}
	
	public int getAttackeeLife() {
		return this.attackeeLife;
	}

  public String getFightStatus() {
		return this.fightStatus;
	}

  public void setAttackDetails(Character p1, Character p2, String status) {
    attackerType = p1.getClass().toString();
    attackerLife = p1.getLife();
    attackerWeaponType = p1.getWeapon().getClass().toString();
    attackerWeaponDamage = p1.getWeapon().getDamage();
    attackeeType = p2.getClass().toString();
    attackeeLife = p2.getLife();
    attackeeWeaponType = p2.getWeapon().getClass().toString();
    attackeeWeaponDamage = p2.getWeapon().getDamage();
    fightStatus = status;
		detailsChanged();
	}
}
