package game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

  @ParameterizedTest
  @CsvSource({ "Knight, Mace, Elf, Mace", "Knight, Mace, Wizard, Mace", "Knight, Wand, Wizard, Wand",
      "Knight, Wand, Elf, Wand", "Wizard, Wand, Elf, Mace", "Wizard, Mace, Elf, Wand", "Elf, Mace, Wizard, Mace",
      "Elf, Wand, Knight, Mace" })
  public void allGameTest(String player1, String weapon1, String player2, String weapon2) {
    Game game = new GameVersion1();
    game.createCharacterPlayerOne(player1);
    game.createCharacterPlayerTwo(player2);
    game.createPlayerOneWeapon(weapon1);
    game.createPlayerTwoWeapon(weapon2);

    game.addDisplay(new FightStatistics());
    game.addDisplay(new AttackDataDisplay());
    game.addDisplay(new AttackDataDisplayInFile());
    game.addDisplay(new FightDataDisplayInFile());
    game.play();

    game.removeDisplay(new FightStatistics());
    game.play();
  }
}
