package  pizzastore.simplefactory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;
public class PizzaStoreTest {
  
  @Test
  public void createPizzaStoreTest(){
    SimplePizzaFactory factory = new SimplePizzaFactory();
    assertNotNull(new PizzaStore(factory));
  }

  static Stream<Arguments> pizzaTypeGenerator() {
    return Stream.of(
        Arguments.of("argie", ArgentinePizza.class),
        Arguments.of("veggie", VeggiePizza.class),
        Arguments.of("clam", ClamPizza.class),
        Arguments.of("pepperoni", PepperoniPizza.class),
        Arguments.of("cheese", CheesePizza.class)
    );
  }


  @ParameterizedTest
  @MethodSource("pizzaTypeGenerator")
  public void createPizzaTest(String type, Class<Pizza> pizzaClass) {
      SimplePizzaFactory factory = new SimplePizzaFactory();
      PizzaStore store = new PizzaStore(factory);
      assertEquals(store.orderPizza(type).getClass(),pizzaClass);
  }
}
