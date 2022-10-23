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
	
	public FightDataDispalyInFile(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserver(this);
    try {
      if(!Files.exists(Paths.get("fight-output.txt"))){
        Files.createFile(Paths.get("fight-output.txt"));
      }
      Files.writeString(Paths.get("fight-output.txt"), "\n", StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
	
	public void update() {
    this.playerReceivesAttackType = gameData.getAttackeeType();
    this.playerAttackType = gameData.getAttackerType();
    this.gameStatus = gameData.getFightStatus();
		display();
	}
	
	public void display() {
		try {
      String text;
      if(gameStatus.equals("start-fight")){
        text = "The battle between " + playerAttackType 
			  + "and " + playerReceivesAttackType + " was started \n" ;
        Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
      }
      else if (gameStatus.equals("end-fight")){
        text = "The battle has ended. \n";
        text += "--------------------------------------------------------------------------------------";
        Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
