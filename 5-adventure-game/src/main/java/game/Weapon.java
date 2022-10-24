package game;

public abstract class Weapon {

  private int damage;
  private int gemLimit;
  // private int currrentGems;

  public Weapon(){
  }

  public Weapon(int damage, int gemLimit){
    this.damage = damage;
    this.gemLimit = gemLimit;
  }

  public void setDamage(int damage){
    this.damage = damage;
  }

  public void setGemLimit(int gemLimit){
    this.gemLimit = gemLimit;
  }

  public int getDamage(){
    return this.damage;
  }

  public int getGemLimit(){
    return this.gemLimit;
  }

  public int getCurrentGems(){
    // return this.currrentGems;
    return 0;
  }

  // public void addGem(){
  //   this.currrentGems++;
  // }
}
