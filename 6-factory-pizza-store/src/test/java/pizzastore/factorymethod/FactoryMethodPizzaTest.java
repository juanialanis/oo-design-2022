package pizzastore.factorymethod;

import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;

public class FactoryMethodPizzaTest {

    static Stream<Arguments> pizzasGenerator() {
        return Stream.of(
            Arguments.of(new NYPizzaStore(), "cheese", NYStyleCheesePizza.class),
            Arguments.of(new NYPizzaStore(), "clam", NYStyleClamPizza.class),
            Arguments.of(new NYPizzaStore(), "pepperoni", NYStylePepperoniPizza.class),
            Arguments.of(new NYPizzaStore(), "veggie", NYStyleVeggiePizza.class),

            Arguments.of(new ArgentinePizzaStore(), "especial", ArgentineStyleEspecialPizza.class),
            Arguments.of(new ArgentinePizzaStore(), "fugazzetta", ArgentineStyleFugazzettaPizza.class),
            Arguments.of(new ArgentinePizzaStore(), "muzza", ArgentineStyleMuzzaPizza.class),

            Arguments.of(new ChicagoPizzaStore(), "cheese", ChicagoStyleCheesePizza.class),
            Arguments.of(new ChicagoPizzaStore(), "clam", ChicagoStyleClamPizza.class),
            Arguments.of(new ChicagoPizzaStore(), "pepperoni", ChicagoStylePepperoniPizza.class),
            Arguments.of(new ChicagoPizzaStore(), "veggie", ChicagoStyleVeggiePizza.class)
        );
    }     

    @ParameterizedTest
    @MethodSource("pizzasGenerator")
    public void factoryMethodPizzaTest(PizzaStore store, String type, Class<pizzastore.factorymethod.Pizza> pizzaClass) {
        assertEquals(store.orderPizza(type).getClass(), pizzaClass);
    }


    static Stream<Arguments> dependentPizzasGenerator() {
        return Stream.of(
            Arguments.of("NY", "cheese", NYStyleCheesePizza.class),
            Arguments.of("NY", "clam", NYStyleClamPizza.class),
            Arguments.of("NY", "pepperoni", NYStylePepperoniPizza.class),
            Arguments.of("NY", "veggie", NYStyleVeggiePizza.class),

            Arguments.of("Argentine", "especial", ArgentineStyleEspecialPizza.class),
            Arguments.of("Argentine", "fugazzetta", ArgentineStyleFugazzettaPizza.class),
            Arguments.of("Argentine", "muzza", ArgentineStyleMuzzaPizza.class),

            Arguments.of("Chicago", "cheese", ChicagoStyleCheesePizza.class),
            Arguments.of("Chicago", "clam", ChicagoStyleClamPizza.class),
            Arguments.of("Chicago", "pepperoni", ChicagoStylePepperoniPizza.class),
            Arguments.of("Chicago", "veggie", ChicagoStyleVeggiePizza.class)
        );
    }     

    @ParameterizedTest
    @MethodSource("dependentPizzasGenerator")
    public void factoryMethodDependentPizzaStore(String style, String type, Class<pizzastore.factorymethod.Pizza> pizzaClass) {
        DependentPizzaStore store = new DependentPizzaStore();
        assertEquals(store.createPizza(style,type).getClass(), pizzaClass);
    }   
}
