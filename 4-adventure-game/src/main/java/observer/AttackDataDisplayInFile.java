package observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AttackDataDisplayInFile implements Observer, DisplayElement {
	private int life;
	private int damageReceived;
	private String playerAttackType;
	private String playerReceivesAttackType;
	private GameData gameData;
	
	public AttackDataDisplayInFile(GameData gameData) {
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
    if(gameData.getFightStatus().equals("attack")){
      this.life = this.gameData.getAttackeeLife();
      this.damageReceived = gameData.getAttackerWeaponDamage();
      this.playerReceivesAttackType = gameData.getAttackeeType();
      this.playerAttackType = gameData.getAttackerType();
      display();
    }
	}
	
	public void display() {
		try {
      String text = "The " + playerAttackType 
			+ "attacks the " + playerReceivesAttackType + " and does " + damageReceived + " points of damage. \n" ;
      Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
      if(life <= 0){
        text = "The " + playerReceivesAttackType + " has died. \n";
        Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
