package game;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class WeaponTest {
  
static Stream<Arguments> weaponClassesAndDamagesGenerator() {
  return Stream.of(
    Arguments.of(new Fist(), 10),
    Arguments.of(new Wand(), 30),
    Arguments.of(new Mace(), 20)
  );
}

@ParameterizedTest
@MethodSource("weaponClassesAndDamagesGenerator")
  public void constructorTest(Weapon weapon, int damage) throws InstantiationException, IllegalAccessException {
    assertEquals(weapon.getDamage(),damage);
  }
}
