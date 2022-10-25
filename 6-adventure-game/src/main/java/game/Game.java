package game;

public abstract class Game {
  
  GameConfiguration config;
  Fight fight;

  public Game(){
    config = new GameConfiguration();
  }

  public GameConfiguration getConfig(){
    return config;
  }

  public void startFight(){
    fight = new Fight(config.player1, config.player2);
    fight.setConfiguration(config);
  }

  public void play(){
    startFight();
    fight.fight();
  }

  abstract Character createCharacter(String item);

  abstract Weapon createWeapon(String item);

  public void createCharacterPlayerOne(String type){
    Character c1 = createCharacter(type);
    config.setPlayer1Character(c1);
  }

  public void createCharacterPlayerTwo(String type){
    Character c2 = createCharacter(type);
    config.setPlayer2Character(c2);
  }

  public void createPlayerOneWeapon(String type){
    Weapon w = createWeapon(type);
    config.setWeaponToPlayerOne(w);
  }

  public void createPlayerTwoWeapon(String type){
    Weapon w = createWeapon(type);
    config.setWeaponToPlayerTwo(w);
  }

}
