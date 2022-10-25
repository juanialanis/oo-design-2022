package game;

public class Fight {
    public Character fighter1;
    public Character fighter2;

    public Character winner;
    public Character loser;

    private GameConfiguration config;

    public void setConfiguration(GameConfiguration g){
      config = g;
    }

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
        if(config != null && config.gameData != null){
          config.gameData.setAttackData(from.getClass().toString(), to.getClass().toString(), attackDamage);
        }
    }

    public void fight() {
      // if(config != null && config.gameData != null){
      //   config.gameData.setAttackDetails(fighter1, fighter2, "start-fight");
      // }
      while(fighter1.isAlive() && fighter2.isAlive()) {
          attack(fighter1, fighter2);
          if (!fighter2.isAlive()) break;
          attack(fighter2, fighter1);
      }
      if(config != null && config.gameData != null){
        if(fighter1.isAlive()){
          config.gameData.setFightEndData(fighter1.getClass().toString(), fighter2.getClass().toString(), fighter1.getWeapon().getClass().toString(), fighter2.getWeapon().getClass().toString());
        }
        else{
          config.gameData.setFightEndData(fighter2.getClass().toString(), fighter1.getClass().toString(), fighter2.getWeapon().getClass().toString(), fighter1.getWeapon().getClass().toString());
        }
      }
    }

}
