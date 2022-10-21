package observer;
	
public class CurrentGameDataDispalyInFile implements Observer, DisplayElement {
	private int life;
	private int damageReceived;
	private String playerAttackType;
	private String playerReceivesAttackType;
	private GameData gameData;
	
	public CurrentGameDataDispalyInFile(GameData gameData) {
		this.gameData = gameData;
		gameData.registerObserver(this);
	}
	
	public void update() {
		this.life = this.gameData.getLife();
		this.damageReceived = gameData.getDamageReceived();
    this.playerReceivesAttackType = gameData.getCharacterReceivesAttackType();
    this.playerAttackType = gameData.getCharacterAttackType();
		display();
	}
	
	public void display() {
		
	}
}
