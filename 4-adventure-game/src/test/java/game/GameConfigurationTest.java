package game;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameConfigurationTest {

    GameConfiguration config;

    @BeforeEach
    public void setUp() {
        config = new GameConfiguration();
    }

    @Test
    public void constructorTest() {
        GameConfiguration config = new GameConfiguration();
        assertNotNull(config);
    }

    static Stream<Arguments> characterGenerator() {
        return Stream.of(
                         Arguments.of(new Knight()),
                         Arguments.of(new Wizard()),
                         Arguments.of(new Elf())
                         );
    }

    @ParameterizedTest
    @MethodSource("characterGenerator")
    public void setAndGetPlayer1Test(Character character) {
        config.setPlayer1Character(character);
        assertEquals(config.getPlayer1Character(), character);
    }

    @ParameterizedTest
    @MethodSource("characterGenerator")
    public void setAndGetPlayer2Test(Character character) {
        config.setPlayer2Character(character);
        assertEquals(config.getPlayer2Character(), character);
    }

    @Test
    public void removeDisplaysTest() {
        int observers = config.getGameData().getNumberOfObservers();
        assertEquals(observers, 4);

        config.removeStandardOutputDisplay();
        observers = config.getGameData().getNumberOfObservers();
        assertEquals(observers, 3);

        config.removeStatisticsDisplay();
        observers = config.getGameData().getNumberOfObservers();
        assertEquals(observers, 2);

        config.removeStandardOutputDisplayInFile();
        observers = config.getGameData().getNumberOfObservers();
        assertEquals(observers, 0);
    }
}
