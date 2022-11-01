package game;

public class AttackDataDisplay extends DisplayElement implements Observer {
  private int damageReceived;
  private String playerAttackType;
  private String playerReceivesAttackType;
  

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
