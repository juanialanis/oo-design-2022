package game;

public class Thor extends Character {

  public Thor() {
    super(250);
    this.setWeapon(new DiamondGem(new DiamondGem(new Mace())));
  }
}
