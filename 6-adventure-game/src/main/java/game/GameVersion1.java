package game;

public class GameVersion1 extends Game {
  
  public Character createCharacter(String type){
    Character character;
    if(type.equals("Knight")){
      character = new Knight();
    }
    else if(type.equals("Wizard")){
      character = new Wizard();
    }
    else if(type.equals("Elf")){
      character = new Elf();
    }
    else{
      throw new IllegalArgumentException("Version 1 does not support this kind of Character");
    }
    return character;
  }

  public Weapon createWeapon(String type){
    Weapon weapon;
    if(type.equals("Fist")){
      weapon = new Fist();
    }
    else if(type.equals("Wand")){
      weapon = new Wand();
    }
    else if(type.equals("Mace")){
      weapon = new Mace();
    }
    else{
      throw new IllegalArgumentException("Version 1 does not support this kind of Weapon");
    }
    return weapon;
  }
}
