package state.coffeemachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeMachineTest {

  CoffeeMachine machine;

  @BeforeEach
  public void setUp() {
    machine = new CoffeeMachine(10);
  }

  @Test
  public void scenario1Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(3);
    machine.pressCoffeeButton("Dark Roast");
    machine.pressCondimentButton("Milk");
    machine.pressCondimentButton("Mocha");
    machine.pressDispenseButton();
  }

  @Test
  public void scenario2Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    machine.pressCoffeeButton("House Blend");
    machine.pressCondimentButton("Scotch");
    machine.pressDispenseButton();
  }

  @Test
  public void scenario3Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(3);
    machine.pressCoffeeButton("House Blend");
    machine.pressCondimentButton("Scotch");
    machine.pressCondimentButton("Whip");
    machine.pressDispenseButton();
  }

  @Test
  public void scenario4Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(3);
    machine.pressCoffeeButton("House Blend");
    machine.pressCondimentButton("Scotch");
    machine.pressCondimentButton("Whip");
    machine.pressDispenseButton();

    machine.insertQuarters(2);
    machine.pressCoffeeButton("House Blend");
    machine.pressCondimentButton("Scotch");
    machine.pressDispenseButton();

    machine.insertQuarters(3);
    machine.pressCoffeeButton("Dark Roast");
    machine.pressCondimentButton("Milk");
    machine.pressCondimentButton("Mocha");
    machine.pressDispenseButton();

    machine.insertQuarters(2);
    machine.pressCoffeeButton("Espresso");
    machine.pressCondimentButton("Soy");
    machine.pressDispenseButton();

    System.out.println(machine.toString());
    machine.refill(10);
    System.out.println(machine.toString());
  }

  @Test
  public void invalidOperation1Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(1);
    machine.pressCoffeeButton("Decaf");
    machine.pressCondimentButton("Soy");
    machine.pressDispenseButton();
  }

  @Test
  public void invalidOperation2Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    machine.pressCoffeeButton("Decaf");
    machine.pressCondimentButton("Soy");
    machine.pressDispenseButton();
    machine.pressCoffeeButton("House Blend");
  }

  @Test
  public void invalidOperation3Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    machine.pressCoffeeButton("Decaf");
    machine.pressCondimentButton("Soy");
    machine.pressDispenseButton();
    machine.pressCondimentButton("Soy");
  }

  @Test
  public void invalidOperation4Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    machine.pressCoffeeButton("Decaf");
    machine.pressCondimentButton("Soy");
    machine.insertQuarters(2);
    machine.pressDispenseButton();
  }

  @Test
  public void invalidOperation5Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    assertThrows(IllegalArgumentException.class, () -> machine.pressCoffeeButton("Colombian"));
  }

  @Test
  public void invalidOperation6Test() {
    System.out.println(machine.toString());
    machine.insertQuarters(2);
    machine.pressCoffeeButton("Espresso");
    assertThrows(IllegalArgumentException.class, () -> machine.pressCondimentButton("Chocolate"));
  }

}
