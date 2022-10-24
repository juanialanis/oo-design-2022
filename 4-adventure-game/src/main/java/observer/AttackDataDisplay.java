package observer;

public class AttackDataDisplay implements Observer, DisplayElement {
  private int playerOneLife;
  private int playerTwoLife;
  private int damageReceived;
  private String playerAttackType;
  private String playerReceivesAttackType;
  private GameData gameData;

  public AttackDataDisplay(GameData gameData) {
    this.gameData = gameData;
    gameData.registerObserver(this);
  }

  public void update() {
    if(gameData.getFightStatus().equals("attack")){
      this.playerOneLife = this.gameData.getAttackeeLife();
      this.playerTwoLife = this.gameData.getAttackerLife();
      this.damageReceived = gameData.getAttackerWeaponDamage();
      this.playerReceivesAttackType = gameData.getAttackeeType();
      this.playerAttackType = gameData.getAttackerType();
      display();
    }
  }

  public void display() {
    System.out.println("The " + playerAttackType
                       + "attacks the " + playerReceivesAttackType + " and does " + damageReceived + " points of damage.");
    if(playerOneLife <= 0){
      System.out.println("The " + playerReceivesAttackType + " has died.");
    }
	}
}
