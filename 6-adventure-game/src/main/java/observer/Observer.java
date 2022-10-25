package observer;

public interface Observer {
	public void updateAttackData();
	public void updateFightData();
  public void setGameData(GameData d);
}
