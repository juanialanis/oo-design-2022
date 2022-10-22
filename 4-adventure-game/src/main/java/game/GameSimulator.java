package game;

public class GameSimulator {
 
	public static void main(String[] args) {
    Game g = new Game();
    GameConfiguration config = g.getConfig();
    config.setPlayer1Character(new Knight());
    config.setPlayer2Character(new Wizard());
    g.play();
	}

}
