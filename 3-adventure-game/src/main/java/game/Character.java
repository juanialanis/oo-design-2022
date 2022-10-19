package game;

public abstract class Character {
  private Weapon weapon;
  private int life; 
  
  public Character(int life){
    this.weapon = new Fist();
    this.life = life;
  }
  
  public void setWeapon(Weapon w){
    this.weapon = w;
  }

  public Weapon getWeapon(){
    return weapon;
  }

  public int getLife(){
    return this.life;
  }

  public void sufferDamage(int damage) {
    this.life = this.life - damage;
  }

  public boolean isAlive() {
    return this.life > 0;
  }

}
