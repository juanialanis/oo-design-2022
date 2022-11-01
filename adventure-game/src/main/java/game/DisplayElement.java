package game;

public abstract class DisplayElement {
  protected GameData gameData;

	public abstract void display();

  public void setGameData(GameData gameData) {
    this.gameData = gameData;
  }
}
