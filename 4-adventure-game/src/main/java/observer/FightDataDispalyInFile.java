package observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FightDataDispalyInFile implements Observer, DisplayElement {
	private String playerAttackType;
	private String playerReceivesAttackType;
  private boolean fightStarted;
	private GameData gameData;
	
	public FightDataDispalyInFile(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserverToFight(this);
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
    this.playerReceivesAttackType = gameData.getCharacterReceivesAttackType();
    this.playerAttackType = gameData.getCharacterAttackType();
    this.fightStarted = gameData.getIsFightStarted();
		display();
	}
	
	public void display() {
		try {
      String text;
      if(fightStarted){
        text = "The battle between " + playerAttackType 
			  + "and " + playerReceivesAttackType + " was started \n" ;
      }
      else{
        text = "The battle has ended. \n";
        text += "--------------------------------------------------------------------------------------";
      }
      Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
