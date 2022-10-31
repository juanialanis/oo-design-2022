package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AttackDataDisplayInFile implements Observer, DisplayElement {
  private int damageReceived;
  private String playerAttackType;
  private String playerReceivesAttackType;
  private GameData gameData;

  public void setGameData(GameData gameData) {
    this.gameData = gameData;
  }

  public AttackDataDisplayInFile() {
    try {
      if (!Files.exists(Paths.get("fight-output.txt"))) {
        Files.createFile(Paths.get("fight-output.txt"));
      }
      Files.writeString(Paths.get("fight-output.txt"), "\n", StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateAttackData() {
    this.damageReceived = gameData.getAttackerWeaponDamage();
    this.playerReceivesAttackType = gameData.getAttackeeType();
    this.playerAttackType = gameData.getAttackerType();
    display();
  }

  public void updateFightData() {
    playerReceivesAttackType = gameData.getAttackeeType();
    displayEnd();
  }

  public void displayEnd() {
    String text = "The " + playerReceivesAttackType + " has died. \n";
    try {
      Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void display() {
    try {
      String text = "The " + playerAttackType + " attacks the " + playerReceivesAttackType + " and does "
          + damageReceived + " points of damage. \n";
      Files.writeString(Paths.get("fight-output.txt"), text, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
