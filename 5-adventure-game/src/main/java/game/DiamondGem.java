package game;

public class DiamondGem extends GemDecorator {
    public DiamondGem (Weapon weapon){
        this.weapon = weapon;
        this.setGemLimit(weapon.getGemLimit());
    }

    public int getDamage() {
        if (this.getCurrentGems() > weapon.getGemLimit()) {
            return weapon.getDamage();
        }
        return weapon.getDamage() * 2;
    }

    public int getCurrentGems() {
        return weapon.getCurrentGems() + 1;
    }
}
