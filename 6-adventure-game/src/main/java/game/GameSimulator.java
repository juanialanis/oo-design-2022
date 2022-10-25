package game;

import observer.AttackDataDispaly;
import observer.FightStatistics;

public class GameSimulator {
 
	public static void main(String[] args) {
    Game g = new GameVersion1();
    g.createCharacterPlayerOne("Knight");
    g.createCharacterPlayerTwo("Elf");
    g.createPlayerOneWeapon("Mace");
    g.config.addDisplay(new FightStatistics());
    g.config.addDisplay(new FightStatistics());
    g.config.addDisplay(new FightStatistics());
    g.play();
    g.config.removeDisplay(new FightStatistics());
    g.play();
	}

}
