package game;


import game.Knight;
import game.Wizard;
import game.Fist;
import game.Weapon;
import game.Character;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class CharacterTest {

  @ParameterizedTest
  @ValueSource (classes = {
    Knight.class,
    Wizard.class
  })
  public void constructorTest(Class<Character> characterClass) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertNotNull(character);
  }

  @ParameterizedTest
  @ValueSource (classes = {
    Knight.class,
    Wizard.class
  })
  public void defaultWeaponFistTest(Class<Character> characterClass) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertTrue(character.getWeapon() instanceof Fist);
  }

  @ParameterizedTest
  @ValueSource (classes = {
    Knight.class,
    Wizard.class
  })
  public void defaultWeaponNotNullTest(Class<Character> characterClass) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertNotNull(character.getWeapon());
  }

  static Stream<Arguments> characterLifeGenerator() {
    return Stream.of(
      Arguments.of(Knight.class, 150),
      Arguments.of(Wizard.class, 100)
    );
  }
  
  @ParameterizedTest
  @MethodSource("characterLifeGenerator")
  public void lifeTest(Class<Character> character, int life) throws InstantiationException, IllegalAccessException {
    assertEquals(character.newInstance().getLife(), life);
  }

  static Stream<Arguments> characterDamageGenerator() {
    return Stream.of(
      Arguments.of(Knight.class, 15),
      Arguments.of(Wizard.class, 12),
      Arguments.of(Knight.class, 15),
      Arguments.of(Wizard.class, 12),
      Arguments.of(Knight.class, 151),
      Arguments.of(Wizard.class, 120)
    );
  }

  @ParameterizedTest
  @MethodSource("characterDamageGenerator")
  public void sufferDamageTest(Class<Character> characterClass, int damage) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    int curLife = character.getLife();
    character.sufferDamage(damage);
    assertEquals(character.getLife(), curLife - damage);
  }

  @ParameterizedTest
  @MethodSource("characterDamageGenerator")
  public void isAliveTest(Class<Character> characterClass, int damage) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    character.sufferDamage(damage);
    assertEquals(character.isAlive(), character.getLife() > 0);
  }

}
