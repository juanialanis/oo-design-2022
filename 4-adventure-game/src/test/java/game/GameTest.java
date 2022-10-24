package game;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameTest {

  Game game;

  @BeforeEach
  public void setUp() {
    game = new Game();
  }

  @Test
  public void gameTest() {
    assertNotNull(game);
  }

  static Stream<Arguments> charactersInFightGenerator() {
    return Stream.of(
                     Arguments.of(new Knight(), new Knight()),
                     Arguments.of(new Wizard(), new Knight()),
                     Arguments.of(new Elf(), new Wizard()),
                     Arguments.of(new Elf(), new Knight())
                     );
  }

  @ParameterizedTest
  @MethodSource("charactersInFightGenerator")
  public void getConfigTest(Character attacker, Character attackee) {
    GameConfiguration config = game.getConfig();
    config.setPlayer1Character(attacker);
    config.setPlayer2Character(attackee);
    assertEquals(game.getConfig().player1.getClass(), attacker.getClass());
    assertEquals(game.getConfig().player2.getClass(), attackee.getClass());
  }


  @ParameterizedTest
  @MethodSource("charactersInFightGenerator")
  public void playTest(Character attacker, Character attackee) {
    GameConfiguration config = game.getConfig();
    config.setPlayer1Character(attacker);
    config.setPlayer2Character(attackee);
    game.play();
    assertTrue(game.getConfig().player1.isAlive() && !game.getConfig().player2.isAlive() || !game.getConfig().player1.isAlive() && game.getConfig().player2.isAlive() );
  }

  static Stream<Arguments> fightScenarioGenerator() {
    return Stream.of(
                     Arguments.of(new Knight(), new Mace(), new Knight(), new Fist()),
                     Arguments.of(new Wizard(), new Wand(),new Knight(), new Mace()),
                     Arguments.of(new Elf(), new Fist(), new Wizard(), new Wand())
                     );
  }


  @ParameterizedTest
  @MethodSource("fightScenarioGenerator")
  public void scenariosTest(Character player1, Weapon weapon1, Character player2, Weapon weapon2) {
    GameConfiguration config = game.getConfig();
    config.setPlayer1Character(player1);
    config.setPlayer2Character(player2);
    config.getPlayer1Character().setWeapon(weapon1);
    config.getPlayer2Character().setWeapon(weapon2);
    config.addFightDataDisplay();
    game.play();
  }
}
