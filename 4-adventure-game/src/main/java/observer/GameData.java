package observer;

public class GameData {
  private AttackData ad;
  private FightData fd;
  private String playerOneType;
  private String playerOneWeapon;
	private String playerTwoType;
	private String playerTwoWeapon;
	private int damageReceived;
  private int life;
  private boolean isFightStarted;

  public GameData(){
    ad = new AttackData();
    fd = new FightData();
  }

  public String getCharacterAttackType() {
		return this.playerOneType;
	}
	
	public String getCharacterReceivesAttackType() {
		return this.playerTwoType;
	}
	
	public int getDamageReceived() {
		return this.damageReceived;
	}

  public int getLife() {
		return this.life;
	}

  public boolean getIsFightStarted() {
		return this.isFightStarted;
	}

  public String getPlayerOneWeapon(){
    return this.playerOneWeapon;
  }

  public String getPlayerTwoWeapon(){
    return this.playerTwoWeapon;
  }

  public void registerObserverToAttack(Observer d){
    ad.registerObserver(d);
  }

  public void removeObserverToAttack(Observer d){
    ad.removeObserver(d);
  }

  public void registerObserverToFight(Observer d){
    fd.registerObserver(d);
  }

  public void removeObserverToFight(Observer d){
    fd.removeObserver(d);
  }

  public void setAttackDetails(String cat, String crat, int damage, int life) {
		this.playerOneType = cat;
		this.playerTwoType = crat;
		this.damageReceived = damage;
		this.life = life;
		ad.attackDetailsChanged();
	}

  public void setFightDetails(boolean fightStarted, String p1type, String p2type) {
    if(fightStarted){
      this.playerOneType = p1type;
      this.playerTwoType = p2type;
      this.isFightStarted = fightStarted;
    }
    else{
      this.playerOneWeapon = p1type;
      this.playerTwoWeapon = p2type;
      this.isFightStarted = fightStarted;
    }
		fd.attackDetailsChanged();
	}
}
