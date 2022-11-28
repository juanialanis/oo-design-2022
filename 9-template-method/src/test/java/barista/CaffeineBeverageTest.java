package barista;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.stream.Stream;

public class CaffeineBeverageTest {
  static Stream<Arguments> beveragesGenerator() {
    return Stream.of(
                     Arguments.of(new BlackCoffee()),
                     Arguments.of(new Tea()),
                     Arguments.of(new Coffee())
                     );
}

@ParameterizedTest
@MethodSource("beveragesGenerator")
public void beveragePrepareRecipeTest(CaffeineBeverage instance) {
  instance.prepareRecipe();
}
}
