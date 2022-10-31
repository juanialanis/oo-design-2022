package game;

public abstract class Game {

  Fight fight;
  GameData gameData;
  Character player1;
  Character player2;

  public Game() {
    gameData = new GameData();
  }

  public void setPlayer1Character(Character p) {
    player1 = p;
  }

  public void setPlayer2Character(Character p) {
    player2 = p;
  }

  public Character getPlayer1Character() {
    return player1;
  }

  public Character getPlayer2Character() {
    return player2;
  }

  public void setWeaponToPlayerOne(Weapon w) {
    player1.setWeapon(w);
  }

  public void setWeaponToPlayerTwo(Weapon w) {
    player2.setWeapon(w);
  }

  public void addDisplay(Observer display) {
    gameData.registerObserver(display);
  }

  public void removeDisplay(Observer display) {
    gameData.removeObserver(display);
  }

  public void startFight() {
    fight = new Fight(this.player1, this.player2);
    fight.setGameData(gameData);
  }

  public void play() {
    startFight();
    fight.fight();
  }

  abstract Character createCharacter(String item);

  abstract Weapon createWeapon(String item);

  public void createCharacterPlayerOne(String type) {
    Character c1 = createCharacter(type);
    this.setPlayer1Character(c1);
  }

  public void createCharacterPlayerTwo(String type) {
    Character c2 = createCharacter(type);
    this.setPlayer2Character(c2);
  }

  public void createPlayerOneWeapon(String type) {
    Weapon w = createWeapon(type);
    this.setWeaponToPlayerOne(w);
  }

  public void createPlayerTwoWeapon(String type) {
    Weapon w = createWeapon(type);
    this.setWeaponToPlayerTwo(w);
  }

}
