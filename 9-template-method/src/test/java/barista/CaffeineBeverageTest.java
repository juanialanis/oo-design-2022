package barista;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class CaffeineBeverageTest {
  static Stream<Arguments> beveragesGenerator() {
    return Stream.of(Arguments.of(new BlackCoffee()), Arguments.of(new Tea()), Arguments.of(new Coffee()));
  }

  @ParameterizedTest
  @MethodSource("beveragesGenerator")
  public void beveragePrepareRecipeTest(CaffeineBeverage instance) {
    instance.prepareRecipe();
  }
}
