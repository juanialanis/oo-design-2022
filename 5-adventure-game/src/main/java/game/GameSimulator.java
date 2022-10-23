package game;

public class GameSimulator {
 
	public static void main(String[] args) {
    Character char1 = new Knight();
    Character char2 = new Wizard();
    char2.setWeapon(new Wand());
		Fight fight = new Fight(char1, char2);
    fight.fight();
	}

}
