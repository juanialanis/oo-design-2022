package game;

import observer.AttackDataDispaly;
import observer.DisplayElement;
import observer.GameData;
import observer.Observer;

public class GameConfiguration {
  
  GameData gameData;	
  Character player1;
  Character player2;

  public GameConfiguration(){
    gameData = new GameData();
  }

  public void setPlayer1Character(Character p){
    player1 = p;
  }

  public void setPlayer2Character(Character p){
    player2 = p;
  }

  public Character getPlayer1Character(){
    return player1;
  }

  public Character getPlayer2Character(){
    return player2;
  }

  public void setWeaponToPlayerOne(Weapon w){
    player1.setWeapon(w);
  }

  public void setWeaponToPlayerTwo(Weapon w){
    player2.setWeapon(w);
  }

  public void addDisplay(Observer display){
    gameData.registerObserver(display);
  }
}
