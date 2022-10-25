package game;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class FightTest {

    static Stream<Arguments> fightGenerator() {
        return Stream.of(
            Arguments.of(new Knight(), new Wizard())
        );
    }

    @ParameterizedTest
    @MethodSource("fightGenerator")
    public void startFightTest(Character char1, Character char2) throws InstantiationException, IllegalAccessException {
        Fight fight = new Fight(char1, char2);
        assertNotNull(fight);
    }

    @ParameterizedTest
    @MethodSource("fightGenerator")
    public void attackReducesLifeTest(Character char1, Character char2) throws InstantiationException, IllegalAccessException {
        Fight fight = new Fight(char1, char2);
        int char1Life = char1.getLife();
        fight.attack(char2, char1);
        assertTrue(char1Life > char1.getLife());
    }

    @ParameterizedTest
    @MethodSource("fightGenerator")
    public void fightResultsInDeathTest(Character char1, Character char2) throws InstantiationException, IllegalAccessException {
        Fight fight = new Fight(char1, char2);
        fight.fight();
        assertFalse(char2.isAlive());
    }

    // Needed to fulfill 100% branch coverage on Fight
    @ParameterizedTest
    @MethodSource("fightGenerator")
    public void fightChar1StartsDeadTest(Character char1, Character char2) throws InstantiationException, IllegalAccessException {
        Fight fight = new Fight(char1, char2);
        char1.sufferDamage(char1.getLife() + 1);
        fight.fight();
        assertFalse(char1.isAlive());
    }

    // Needed to fulfill 100% branch coverage on Fight
    @ParameterizedTest
    @MethodSource("fightGenerator")
    public void fightChar2StartsDeadTest(Character char1, Character char2) throws InstantiationException, IllegalAccessException {
        Fight fight = new Fight(char1, char2);
        char2.sufferDamage(char2.getLife() + 1);
        fight.fight();
        assertFalse(char2.isAlive());
    }

    static Stream<Arguments> attackGeneratorWithWeaponChange() {
      return Stream.of(
          Arguments.of(new Knight(), new Wizard(),Wand.class)
      );
  }

    @ParameterizedTest
    @MethodSource("attackGeneratorWithWeaponChange")
    public void attackWithDifferentWeapons(Character char1, Character char2, Class<Weapon> weaponClass) throws InstantiationException, IllegalAccessException{
      Weapon w = weaponClass.newInstance();
      char2.setWeapon(w);
      Fight fight = new Fight(char1, char2);
      int previousLife = char1.getLife();
      fight.attack(char2, char1);
      assertEquals(previousLife - w.getDamage(), char1.getLife());
    }

}
