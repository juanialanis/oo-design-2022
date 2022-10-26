package  pizzastore.abstractfactory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;
public class PizzaTest {

  static Stream<Arguments> allPizzasToString() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaStore(), "muzza"),
      Arguments.of(new ArgentinePizzaStore(), "especial"),
      Arguments.of(new ArgentinePizzaStore(), "fugazzetta"),
      Arguments.of(new ChicagoPizzaStore(), "cheese"),
      Arguments.of(new ChicagoPizzaStore(), "veggie"),
      Arguments.of(new ChicagoPizzaStore(), "clam"),
      Arguments.of(new ChicagoPizzaStore(), "pepperoni"),
      Arguments.of(new NYPizzaStore(), "cheese"),
      Arguments.of(new NYPizzaStore(), "veggie"),
      Arguments.of(new NYPizzaStore(), "clam"),
      Arguments.of(new NYPizzaStore(), "pepperoni"),
      Arguments.of(new NYPizzaStore(), "nopizza")
    );
  }


  @ParameterizedTest
  @MethodSource("allPizzasToString")
  public void pizzaToStringTest(PizzaStore store, String type){
    Pizza p = store.orderPizza(type);
    System.out.println(p.toString());
    assertNotNull(p.toString());
  }
  
}
