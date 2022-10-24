package game;

public class GameSimulator {
 
	public static void main(String[] args) {
    Game g = new Game();
    GameConfiguration config = g.getConfig();
    Character knight = new Knight();
    knight.setWeapon(new Mace());
    config.setPlayer1Character(knight);
    config.setPlayer2Character(new Elf());
    g.play();
	}

}
