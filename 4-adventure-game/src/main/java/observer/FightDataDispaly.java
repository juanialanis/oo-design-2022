package observer;
	
public class FightDataDispaly implements Observer, DisplayElement {
	private int life;
	private int damageReceived;
	private String playerAttackType;
	private String playerReceivesAttackType;
	private GameData gameData;
	
	public FightDataDispaly(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserverToAttack(this);
	}
	
	public void update() {
		this.life = this.gameData.getLife();
		this.damageReceived = gameData.getDamageReceived();
    this.playerReceivesAttackType = gameData.getCharacterReceivesAttackType();
    this.playerAttackType = gameData.getCharacterAttackType();
		display();
	}
	
	public void display() {
		System.out.println("The " + playerAttackType 
			+ "attacks the " + playerReceivesAttackType + " and does " + damageReceived + " points of damage.");
    if(life <= 0){
      System.out.println("The " + playerReceivesAttackType + " has died.");
    }
	}
}
