package game;

public class AttackDataDisplay implements Observer, DisplayElement {
  private int damageReceived;
  private String playerAttackType;
  private String playerReceivesAttackType;
  private GameData gameData;

  public void setGameData(GameData gameData) {
    this.gameData = gameData;
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
    System.out.println("The " + playerReceivesAttackType + " has died.");
  }

  public void display() {
    System.out.println("The " + playerAttackType + " attacks the " + playerReceivesAttackType + " and does "
        + damageReceived + " points of damage.");
  }
}
