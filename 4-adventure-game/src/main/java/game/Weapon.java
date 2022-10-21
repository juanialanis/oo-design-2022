package game;

public abstract class Weapon {

  private final int damage;

  public Weapon(int damage){
    this.damage = damage;
  }

  public int getDamage(){
    return this.damage;
  }
}
