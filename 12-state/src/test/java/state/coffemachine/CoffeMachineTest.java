package  state.coffeemachine;

import static org.assertj.core.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeMachineTest {
  
  CoffeeMachine machine;

  @BeforeEach
  public void setUp() {
      machine = new CoffeeMachine(10);
  }

  @Test
  public void validOperationTest(){
    machine.insertQuarters(3);
    machine.pressCoffeeButton("Dark Roast");
    machine.pressCondimentButton("Milk");
    machine.pressCondimentButton("Mocha");
    machine.pressDispenseButton();
  }

  @Test
  public void invalidOperationTest(){
    machine.insertQuarters(1);
    machine.pressCoffeeButton("Decaf");
    machine.pressCondimentButton("Soy");
    machine.pressDispenseButton();
  }


}
