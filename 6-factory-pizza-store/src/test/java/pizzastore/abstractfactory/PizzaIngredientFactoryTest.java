package  pizzastore.abstractfactory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class PizzaIngredientFactoryTest{

  static Stream<Arguments> doughFactoryGenerator() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaIngredientFactory(), ThickCrustDough.class),
      Arguments.of(new ChicagoPizzaIngredientFactory(), ThickCrustDough.class),
      Arguments.of(new NYPizzaIngredientFactory(), ThinCrustDough.class)
    );
  }


  @ParameterizedTest
  @MethodSource("doughFactoryGenerator")
  public void createDough(PizzaIngredientFactory factory, Class<Dough> doughClass){
    assertEquals(factory.createDough().getClass() ,doughClass);
  }

  static Stream<Arguments> sauceFactoryGenerator() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaIngredientFactory(), TomatoSauce.class),
      Arguments.of(new ChicagoPizzaIngredientFactory(), PlumTomatoSauce.class),
      Arguments.of(new NYPizzaIngredientFactory(), MarinaraSauce.class)
    );
  }


  @ParameterizedTest
  @MethodSource("sauceFactoryGenerator")
  public void createSauce(PizzaIngredientFactory factory, Class<Sauce> sauceClass){
    assertEquals(factory.createSauce().getClass() ,sauceClass);
  }

  static Stream<Arguments> cheeseFactoryGenerator() {
    return Stream.of(
      Arguments.of(new ArgentinePizzaIngredientFactory(), MozzarellaCheese.class),
      Arguments.of(new ChicagoPizzaIngredientFactory(), MozzarellaCheese.class),
      Arguments.of(new NYPizzaIngredientFactory(), ReggianoCheese.class)
    );
  }

  @ParameterizedTest
  @MethodSource("cheeseFactoryGenerator")
  public void createCheese(PizzaIngredientFactory factory, Class<Sauce> sauceClass){
    assertEquals(factory.createCheese().getClass() ,sauceClass);
  }
  
  static Stream<Arguments> veggiesFactoryGenerator() {
    Veggies[] nyArray = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    Veggies[] chicagoArray = { new BlackOlives(), 
      new Spinach(), 
      new Eggplant() };
    Veggies[] argentineArray = {new Onion(), new RedPepper()};
    return Stream.of(
      Arguments.of(new ArgentinePizzaIngredientFactory(), argentineArray),
      Arguments.of(new ChicagoPizzaIngredientFactory(), chicagoArray),
      Arguments.of(new NYPizzaIngredientFactory(), nyArray)
    );
  }

  @ParameterizedTest
  @MethodSource("veggiesFactoryGenerator")
  public void createVeggies(PizzaIngredientFactory factory, Veggies[] veggies){
    Veggies[] resultantVeggies = factory.createVeggies();
    for(int i = 0; i < resultantVeggies.length; i++){
      assertEquals(resultantVeggies[i].getClass(),veggies[i].getClass());
    }
    assertEquals(resultantVeggies.length, veggies.length);
  }

  static Stream<Arguments> meatsFactoryGenerator() {
    Meat[] nyArray = {new FreshClams(), new SlicedPepperoni()};
    Meat[] chicagoArray = {new FrozenClams(), new SlicedPepperoni()};
    Meat[] argentineArray = { new Ham() };
    return Stream.of(
      Arguments.of(new ArgentinePizzaIngredientFactory(), argentineArray),
      Arguments.of(new ChicagoPizzaIngredientFactory(), chicagoArray),
      Arguments.of(new NYPizzaIngredientFactory(), nyArray)
    );
  }

  @ParameterizedTest
  @MethodSource("meatsFactoryGenerator")
  public void createMeats(PizzaIngredientFactory factory, Meat[] meats){
    Meat[] resultantMeats = factory.createMeat();
    for(int i = 0; i < resultantMeats.length; i++){
      assertEquals(resultantMeats[i].getClass(),meats[i].getClass());
    }
    assertEquals(resultantMeats.length, meats.length);
  }
}