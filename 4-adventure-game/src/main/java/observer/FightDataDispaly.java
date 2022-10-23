package observer;
	
public class FightDataDispaly implements Observer, DisplayElement {
	private int life;
	private int damageReceived;
	private String playerAttackType;
	private String playerReceivesAttackType;
	private GameData gameData;
	
	public FightDataDispaly(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserver(this);
	}
	
	public void update() {
		this.life = this.gameData.getAttackeeLife();
		this.damageReceived = gameData.getAttackerWeaponDamage();
    this.playerReceivesAttackType = gameData.getAttackeeType();
    this.playerAttackType = gameData.getAttackerType();
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
