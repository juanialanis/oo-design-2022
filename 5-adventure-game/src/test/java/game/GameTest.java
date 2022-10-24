package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameTest {
  @Test
  public void allGameTest(){
    Game g = new Game();
    assertNotNull(g);
    GameConfiguration config = g.getConfig();
    config.setPlayer1Character(new Knight());
    config.setPlayer2Character(new Wizard());
    assertEquals(g.getConfig().player1.getClass(), Knight.class);
    assertEquals(g.getConfig().player2.getClass(), Wizard.class);
    g.play();
    assertTrue(g.getConfig().player1.isAlive() && !g.getConfig().player2.isAlive() || !g.getConfig().player1.isAlive() && g.getConfig().player2.isAlive() );
  } 
}
