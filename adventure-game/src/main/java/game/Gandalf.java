package game;

public class Gandalf extends Character {

  public Gandalf() {
    super(200);
    this.setWeapon(new SilmarilGem(new Wand()));
  }
}
