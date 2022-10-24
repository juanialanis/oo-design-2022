package game;

public class Game {
  
  private GameConfiguration config;
  private Fight fight;

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
}
