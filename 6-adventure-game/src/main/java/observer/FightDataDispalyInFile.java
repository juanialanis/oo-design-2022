package observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FightDataDispalyInFile implements Observer, DisplayElement {
	private String playerAttackType;
	private String playerReceivesAttackType;
  private String gameStatus;
	private GameData gameData;

  public void setGameData(GameData gameData){
    this.gameData = gameData;
  }
	
	public FightDataDispalyInFile() {
    try {
      if(!Files.exists(Paths.get("fight-output.txt"))){
        Files.createFile(Paths.get("fight-output.txt"));
      }
      Files.writeString(Paths.get("fight-output.txt"), "\n", StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
	}

  public void updateAttackData(){
  
  }
	
	public void updateFightData() {
    this.playerReceivesAttackType = gameData.getAttackeeType();
    this.playerAttackType = gameData.getAttackerType();
		display();
	}
	
	public void display() {
		try {
      String text;
      text = "The battle has ended. \n";
      text += "--------------------------------------------------------------------------------------";
      Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
