package observer;

import java.util.ArrayList;
import java.util.List;

public class GameData {
  private String attackerType;
  private String attackerWeaponType;
  private String attackeeType;
  private String attackeeWeaponType;
  private int attackerLife;
  private int attackeeLife;
  private int attackerWeaponDamage;
  private int attackeeWeaponDamage;
  private List<Observer> observers;

  public GameData(){
    observers = new ArrayList<Observer>();
  }
	
	public void registerObserver(Observer o) {
    o.setGameData(this);
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyAttackObservers() {
		for (Observer observer : observers) {
			observer.updateAttackData();
		}
	}

  public void notifyFightObservers() {
		for (Observer observer : observers) {
			observer.updateFightData();
		}
	}

  public void attackDetailsChanged() {
		notifyAttackObservers();
	}
	
	public void fightDetailsChanged() {
		notifyFightObservers();
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

  public void setAttackData(String fromType,String toType, int damage) {
    attackerType = fromType;
    attackeeType = toType;
    attackerWeaponDamage = damage;
		attackDetailsChanged();
	}

  public void setFightEndData(String winnerType, String loserType, String winnerWeapon, String loserWeapon){
    this.attackerType = winnerType;
    this.attackeeType = loserType;
    this.attackerWeaponType = winnerWeapon;
    this.attackeeWeaponType = loserWeapon;
		fightDetailsChanged();
  }
}
