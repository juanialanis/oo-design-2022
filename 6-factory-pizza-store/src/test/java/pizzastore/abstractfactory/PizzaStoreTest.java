package  pizzastore.abstractfactory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class PizzaStoreTest {
  
  static Stream<Arguments> createPizzasOfStores() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaStore(), "muzza", MuzzaPizza.class),
      Arguments.of(new ArgentinePizzaStore(), "especial", EspecialPizza.class),
      Arguments.of(new ArgentinePizzaStore(), "fugazzetta", FugazzettaPizza.class),
      Arguments.of(new ChicagoPizzaStore(), "cheese", CheesePizza.class),
      Arguments.of(new ChicagoPizzaStore(), "veggie", VeggiePizza.class),
      Arguments.of(new ChicagoPizzaStore(), "clam", ClamPizza.class),
      Arguments.of(new ChicagoPizzaStore(), "pepperoni", PepperoniPizza.class),
      Arguments.of(new NYPizzaStore(), "cheese", CheesePizza.class),
      Arguments.of(new NYPizzaStore(), "veggie", VeggiePizza.class),
      Arguments.of(new NYPizzaStore(), "clam", ClamPizza.class),
      Arguments.of(new NYPizzaStore(), "pepperoni", PepperoniPizza.class)
    );
  }


  @ParameterizedTest
  @MethodSource("createPizzasOfStores")
  public void createPizzaTest(PizzaStore store, String type ,Class<Pizza> pizzaClass){
    assertEquals(store.createPizza(type).getClass(), pizzaClass);
  }

  @ParameterizedTest
  @MethodSource("createPizzasOfStores")
  public void orderPizzaTest(PizzaStore store, String type ,Class<Pizza> pizzaClass){
    assertEquals(store.orderPizza(type).getClass(), pizzaClass);
  }

  static Stream<Arguments> createPizzasNotExistsOfStores() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaStore()),
      Arguments.of(new ChicagoPizzaStore()),
      Arguments.of(new NYPizzaStore())
    );
  }


  @ParameterizedTest
  @MethodSource("createPizzasOfStores")
  public void pizzaNotExsitTest(PizzaStore store){
    assertNull(store.createPizza("not exist"));
  }
}
