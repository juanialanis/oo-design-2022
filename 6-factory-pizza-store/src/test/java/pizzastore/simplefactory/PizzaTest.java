package  pizzastore.simplefactory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class PizzaTest {

  static Stream<Arguments> pizzaTypeAndNameGenerator() {
    return Stream.of(
      Arguments.of("argie", "Argentine Pizza"),
      Arguments.of("veggie", "Veggie Pizza"),
      Arguments.of("clam", "Clam Pizza"),
      Arguments.of("pepperoni", "Pepperoni Pizza"),
      Arguments.of("cheese", "Cheese Pizza")
    );
  }


  @ParameterizedTest
  @MethodSource("pizzaTypeAndNameGenerator")
  public void getNameTest(String type, String pizzaName) {
    SimplePizzaFactory factory = new SimplePizzaFactory();
    PizzaStore store = new PizzaStore(factory);
    Pizza pizza = store.orderPizza(type);
    assertEquals(pizza.getName(),pizzaName);
  }

  static Stream<Arguments> pizzaTypeAndStringGenerator() {
    return Stream.of(
      Arguments.of("argie"),
      Arguments.of("veggie"),
      Arguments.of("clam"),
      Arguments.of("pepperoni"),
      Arguments.of("cheese")
    );
  }


  @ParameterizedTest
  @MethodSource("pizzaTypeAndStringGenerator")
  public void toStringTest(String type) {
    SimplePizzaFactory factory = new SimplePizzaFactory();
    PizzaStore store = new PizzaStore(factory);
    Pizza pizza = store.orderPizza(type);
    assertNotNull(pizza.toString());
  }
}
