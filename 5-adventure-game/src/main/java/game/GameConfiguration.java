package game;


import observer.AttackDataDispaly;
import observer.AttackDataDispalyInFile;
import observer.FightDataDispalyInFile;
import observer.FightStatistics;
import observer.GameData;

public class GameConfiguration {
  
  GameData gameData;	
  Character player1;
  Character player2;
  AttackDataDispaly cgdd;
  AttackDataDispalyInFile cgddif;
  FightDataDispalyInFile fddif;
  FightStatistics fs;

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
    cgdd = new AttackDataDispaly(gameData);
  }

  public void removeStandardOutputDisplay(){
    gameData.removeObserver(cgdd);
  }

  public void addStatisticsDisplay(){
    fs = new FightStatistics(gameData);
  }

  public void removeStatisticsDisplay(){
    gameData.removeObserver(fs);
  }

  public void addStandardOutputDisplayInFile(){
    cgddif = new AttackDataDispalyInFile(gameData);
    fddif = new FightDataDispalyInFile(gameData);
  }

  public void removeStandardOutputDisplayInFile(){
    gameData.removeObserver(cgddif);
  }
  
}
