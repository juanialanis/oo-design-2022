package stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class StringCalculatorTest {

  static Stream<Arguments> addTestGenerator() {
    return Stream.of(
      Arguments.of("", 0),
      Arguments.of("1", 1),
      Arguments.of("1,2", 3),
      Arguments.of("1,2,3", 6),
      Arguments.of("1\n2,3", 6),
      Arguments.of("//;\n1;2;3", 6),
      Arguments.of("//;\n1;2;3;1000;1001", 1006),
      Arguments.of("//;;\n1;;2;;3;;1000;;1001", 1006),
      Arguments.of("//[***][%]\n1***2%3", 6)
    );
  }

  @ParameterizedTest
  @MethodSource("addTestGenerator")
  public void isFizzBuzzTestFalse(String number, int result){
    assertEquals(StringCalculator.add(number),result);
  }

  @Test
  public void addNegativeNumber(){
    assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("1,-3"));
  }
}
