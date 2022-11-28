package calculator;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class CalculatorTest {

    static Stream<Arguments> primesCalculatorGenerator() {
        return Stream.of(
                         Arguments.of(new CalculatorEratosthenes(), 3),
                         Arguments.of(new CalculatorEratosthenes(), 10),
                         Arguments.of(new CalculatorEratosthenes(), 15),
                         Arguments.of(new CalculatorCheckEach(), 3),
                         Arguments.of(new CalculatorCheckEach(), 10),
                         Arguments.of(new CalculatorCheckEach(), 15)
                         );
    }

    @ParameterizedTest
    @MethodSource("primesCalculatorGenerator")
    public void primesTest(Calculator calculator, int n) {
        Calculator calc = calculator;
        calc.calculate(n);
    }
}
