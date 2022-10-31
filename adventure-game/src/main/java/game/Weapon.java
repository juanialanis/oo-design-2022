package game;

public abstract class Weapon {

  private int damage;
  private int gemLimit;

  public Weapon() {
  }

  public Weapon(int damage, int gemLimit) {
    this.damage = damage;
    this.gemLimit = gemLimit;
  }

  public void setGemLimit(int gemLimit) {
    this.gemLimit = gemLimit;
  }

  public int getDamage() {
    return this.damage;
  }

  public int getGemLimit() {
    return this.gemLimit;
  }

  public int getCurrentGems() {
    return 0;
  }

}
