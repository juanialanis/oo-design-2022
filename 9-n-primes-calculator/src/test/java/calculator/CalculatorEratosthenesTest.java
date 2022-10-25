package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CalculatorEratosthenesTest {

    CalculatorBehavior calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorEratosthenes();
    }

    static Stream<Arguments> primesGenerator() {
        return Stream.of(
                         Arguments.of(3, new ArrayList<Integer>(Arrays.asList(2,3,5))),
                         Arguments.of(10, new ArrayList<Integer>(Arrays.asList(2,3,5,7,11,13,17,19,23,29)))
                         );
    }


    @ParameterizedTest
    @MethodSource("primesGenerator")
    public void isPrimeTest(int n, ArrayList<Integer> result) {
        assertTrue(calculator.calculate(n).equals(result));
    }
}
