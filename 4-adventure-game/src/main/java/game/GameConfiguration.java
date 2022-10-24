package game;

import observer.*;

public class GameConfiguration {
  
  GameData gameData;
  Character player1;
  Character player2;
  AttackDataDisplay cgdd;
  AttackDataDisplayInFile cgddif;
  FightDataDisplayInFile fddif;
  FightStatistics fs;
  FightDataDisplay fightDataDisplay;

  public GameConfiguration(){
    gameData = new GameData();
    addStandardOutputDisplay();
    addStandardOutputDisplayInFile();
    addStatisticsDisplay();
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

  public void addStandardOutputDisplay(){
    cgdd = new AttackDataDisplay(gameData);
  }

  public void removeStandardOutputDisplay(){
    gameData.removeObserver(cgdd);
  }

  public void addFightDataDisplay() {
    fightDataDisplay = new FightDataDisplay(gameData);
  }

  public void removeFightDataDisplay() {
    gameData.removeObserver(fightDataDisplay);
  }

  public void addStatisticsDisplay(){
    fs = new FightStatistics(gameData);
  }

  public void removeStatisticsDisplay(){
    gameData.removeObserver(fs);
  }

  public void addStandardOutputDisplayInFile(){
    cgddif = new AttackDataDisplayInFile(gameData);
    fddif = new FightDataDisplayInFile(gameData);
  }

  public void removeStandardOutputDisplayInFile(){
    gameData.removeObserver(cgddif);
    gameData.removeObserver(fddif);
  }

  public GameData getGameData() {
    return this.gameData;
  }
}
