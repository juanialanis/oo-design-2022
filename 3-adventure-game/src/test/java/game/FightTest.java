package game;

import game.Knight;
import game.Fight;
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
}
