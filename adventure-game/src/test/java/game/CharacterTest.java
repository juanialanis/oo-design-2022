package game;

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
  @ValueSource(classes = { Knight.class, Wizard.class, Elf.class })
  public void constructorTest(Class<Character> characterClass) throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertNotNull(character);
  }

  @ParameterizedTest
  @ValueSource(classes = { Knight.class, Wizard.class, Elf.class })
  public void defaultWeaponFistTest(Class<Character> characterClass)
      throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertTrue(character.getWeapon() instanceof Fist);
  }

  @ParameterizedTest
  @ValueSource(classes = { Knight.class, Wizard.class, Elf.class })
  public void defaultWeaponNotNullTest(Class<Character> characterClass)
      throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    assertNotNull(character.getWeapon());
  }

  static Stream<Arguments> characterLifeGenerator() {
    return Stream.of(Arguments.of(Knight.class, 150), Arguments.of(Wizard.class, 100), Arguments.of(Elf.class, 200));
  }

  @ParameterizedTest
  @MethodSource("characterLifeGenerator")
  public void lifeTest(Class<Character> character, int life) throws InstantiationException, IllegalAccessException {
    assertEquals(character.newInstance().getLife(), life);
  }

  static Stream<Arguments> characterDamageGenerator() {
    return Stream.of(Arguments.of(Knight.class, 15), Arguments.of(Wizard.class, 12), Arguments.of(Knight.class, 15),
        Arguments.of(Wizard.class, 12), Arguments.of(Knight.class, 151), Arguments.of(Wizard.class, 120),
        Arguments.of(Elf.class, 50), Arguments.of(Elf.class, 202));
  }

  @ParameterizedTest
  @MethodSource("characterDamageGenerator")
  public void sufferDamageTest(Class<Character> characterClass, int damage)
      throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    int curLife = character.getLife();
    character.sufferDamage(damage);
    assertEquals(character.getLife(), curLife - damage);
  }

  @ParameterizedTest
  @MethodSource("characterDamageGenerator")
  public void isAliveTest(Class<Character> characterClass, int damage)
      throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    character.sufferDamage(damage);
    assertEquals(character.isAlive(), character.getLife() > 0);
  }

  static Stream<Arguments> characterChangeWeaponGenerator() {
    return Stream.of(Arguments.of(Knight.class, Wand.class), Arguments.of(Wizard.class, Wand.class),
        Arguments.of(Knight.class, Mace.class), Arguments.of(Wizard.class, Mace.class),
        Arguments.of(Elf.class, Wand.class), Arguments.of(Elf.class, Mace.class));
  }

  @ParameterizedTest
  @MethodSource("characterChangeWeaponGenerator")
  public void changeWeaponTest(Class<Character> characterClass, Class<Weapon> weaponClass)
      throws InstantiationException, IllegalAccessException {
    Character character = characterClass.newInstance();
    Weapon w = weaponClass.newInstance();
    character.setWeapon(w);
    assertEquals(character.getWeapon().getClass(), w.getClass());
  }

  @Test
  public void gandalfTest() {
    Character gandalf = new Gandalf();
    assertEquals(gandalf.getLife(), 200);
    assertEquals(gandalf.getWeapon().getClass(), SilmarilGem.class);
  }

  @Test
  public void thorTest() {
    Character thor = new Thor();
    assertEquals(thor.getLife(), 250);
    assertEquals(thor.getWeapon().getClass(), DiamondGem.class);
  }

}
