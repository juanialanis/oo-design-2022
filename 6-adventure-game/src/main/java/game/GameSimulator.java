package game;

import observer.AttackDataDispaly;

public class GameSimulator {
 
	public static void main(String[] args) {
    Game g = new GameVersion1();
    g.createCharacterPlayerOne("Knight");
    g.createCharacterPlayerTwo("Elf");
    g.createPlayerOneWeapon("Mace");
    g.config.addDisplay(new AttackDataDispaly());
    g.play();
	}

}
