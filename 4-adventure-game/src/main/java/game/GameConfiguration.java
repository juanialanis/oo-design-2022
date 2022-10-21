package game;


import observer.CurrentGameDataDispaly;
import observer.CurrentGameDataDispalyInFile;
import observer.GameData;

public class GameConfiguration {
  
  GameData gameData;	
  Character player1;
  Character player2;
  CurrentGameDataDispaly cgdd;
  CurrentGameDataDispalyInFile cgddif;

  public GameConfiguration(){
    gameData = new GameData();
    addStandardOutputDisplay();
    addStandardOutputDisplayInFile();
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
    cgdd = new CurrentGameDataDispaly(gameData);
  }

  public void removeStandardOutputDisplay(){
    gameData.removeObserver(cgdd);
  }

  public void addStandardOutputDisplayInFile(){
    cgddif = new CurrentGameDataDispalyInFile(gameData);
  }

  public void removeStandardOutputDisplayInFile(){
    gameData.removeObserver(cgddif);
  }
}
