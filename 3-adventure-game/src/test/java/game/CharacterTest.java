package test.java.game;


import main.java.game.Knight;
import main.java.game.Wizard;
import main.java.game.Fist;
import main.java.game.Weapon;
import main.java.game.Character;
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

}
