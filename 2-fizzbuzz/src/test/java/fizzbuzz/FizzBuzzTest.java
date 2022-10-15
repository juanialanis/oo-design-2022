package test.java.fizzbuzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import main.java.fizzbuzz.FizzBuzz;
import java.util.stream.Stream;


public class FizzBuzzTest {

  static Stream<Arguments> isFizzBuzzGenerator() {
    return Stream.of(
      Arguments.of(1, false),
      Arguments.of(3, false),
      Arguments.of(5, false),
      Arguments.of(15, true),
      Arguments.of(53, true)
    );
  }

  @ParameterizedTest
  @MethodSource("isFizzBuzzGenerator")
  public void IsFizzBuzzTestFalse(int n, boolean value){
    assertEquals(FizzBuzz.isFizzBuzz(n),value);
  }

  static Stream<Arguments> isFizzGenerator() {
    return Stream.of(
      Arguments.of(1, false),
      Arguments.of(3, true),
      Arguments.of(5, false),
      Arguments.of(31, true)
    );
  }

  @ParameterizedTest
  @MethodSource("isFizzGenerator")
  public void IsFizzTest(int n, boolean value){
    assertEquals(FizzBuzz.isFizz(n),value);
  }

  static Stream<Arguments> isBuzzGenerator() {
    return Stream.of(
      Arguments.of(1, false),
      Arguments.of(3, false),
      Arguments.of(5, true),
      Arguments.of(51, true)
    );
  }

  @ParameterizedTest
  @MethodSource("isBuzzGenerator")
  public void IsBuzzTest(int n, boolean value){
    assertEquals(FizzBuzz.isBuzz(n),value);
  }

  static Stream<Arguments> isFizzBuzzOrNumberGenerator() {
    return Stream.of(
      Arguments.of(1, 1),
      Arguments.of(3, "Fizz"),
      Arguments.of(5, "Buzz"),
      Arguments.of(15, "FizzBuzz"),
      Arguments.of(31, "Fizz"),
      Arguments.of(52, "Buzz"),
      Arguments.of(53, "FizzBuzz")
    );
  }

  @ParameterizedTest
  @MethodSource("isFizzBuzzOrNumberGenerator")
  public void IsFizzBuzzTest(int n, Object e){
    assertEquals(FizzBuzz.isFizzBuzzOrNumber(n),e);
  }
}
