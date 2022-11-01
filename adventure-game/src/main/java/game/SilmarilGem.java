package game;

import java.lang.Math;

public class SilmarilGem extends GemDecorator {
    public SilmarilGem (Weapon weapon){
        this.weapon = weapon;
        this.setGemLimit(weapon.getGemLimit());
    }

    public int getDamage() {
        int current = this.getCurrentGems();
        if (current > weapon.getGemLimit()) {
            return weapon.getDamage();
        }
        return (int) Math.pow(weapon.getDamage(), 2);
    }

    public int getCurrentGems() {
        return weapon.getCurrentGems() + 2;
    }
}
