package state.gumballmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GumballMachineTest {

  GumballMachine gumballMachine;

  @BeforeEach
  public void setUp() {
    gumballMachine = new GumballMachine(2);
  }

  @Test
  public void scenario1Test() {
    System.out.println(gumballMachine);
    gumballMachine.insertQuarter(2);
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

  @Test
  public void scenario2Test() {
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

  @Test
  public void scenario3Test() {
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

  @Test
  public void scenario4Test() {
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

  @Test
  public void scenario5Test() {
    System.out.println(gumballMachine);

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

  @Test
  public void invalidOperationTest() {
    gumballMachine.insertQuarter(2);
    gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
  }

}
