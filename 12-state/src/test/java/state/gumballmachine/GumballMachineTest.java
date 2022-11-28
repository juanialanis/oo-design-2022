package  state.gumballmachine;

import static org.assertj.core.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GumballMachineTest {
  
  GumballMachine gumballMachine;

  @BeforeEach
  public void setUp() {
    gumballMachine = new GumballMachine(2);
  }

  @Test
  public void validOperationTest(){
		gumballMachine.insertQuarter(2);
		gumballMachine.turnCrank();
  }

  @Test
  public void invalidOperationTest(){
    gumballMachine.insertQuarter(2);
		gumballMachine.turnCrank();
    gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
  }


}
