package game;

public class Fight {

    public Character fighter1;
    public Character fighter2;

    public Character winner;
    public Character loser;

    public Fight(Character fighter1, Character fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public void attack(Character from, Character to) {
        int attackDamage = from.getWeapon().getDamage();
        to.sufferDamage(attackDamage);
        if (!to.isAlive()) {
            this.winner = from;
            this.loser = to;
        }
    }

    public void fight() {
        while(fighter1.isAlive() && fighter2.isAlive()) {
            attack(fighter1, fighter2);
            if (!fighter2.isAlive()) break;
            attack(fighter2, fighter1);
        }
    }

}
