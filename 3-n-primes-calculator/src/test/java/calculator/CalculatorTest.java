package calculator;

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

public class CalculatorTest {

    static Stream<Arguments> primesCalculatorGenerator() {
        return Stream.of(
                         Arguments.of(new EratosthenesCalculator(), new ShowResultsPrint(), 3),
                         Arguments.of(new EratosthenesCalculator(), new ShowResultsFile(), 5),
                         Arguments.of(new IteratorCalculator(), new ShowResultsPrint(), 10),
                         Arguments.of(new IteratorCalculator(), new ShowResultsFile(), 15),
                         Arguments.of(new EratosthenesCalculator(), new ShowResultsPrint(), 20),
                         Arguments.of(new EratosthenesCalculator(), new ShowResultsFile(), 25),
                         Arguments.of(new IteratorCalculator(), new ShowResultsPrint(), 30),
                         Arguments.of(new IteratorCalculator(), new ShowResultsFile(), 25)
                         );
    }

    @ParameterizedTest
    @MethodSource("primesCalculatorGenerator")
    public void primesTest(Calculator calculator, ShowResultsBehavior outputBehavior, int n) {
        Calculator calc = calculator;
        calc.setShowResultsBehavior(outputBehavior);
        calc.performCalculate(n);
        calc.performShow();
    }

    static Stream<Arguments> changeCalculatorBehaviorGenerator() {
        return Stream.of(
                         Arguments.of(new EratosthenesCalculator(), new CalculatorCheckEach() , 3),
                         Arguments.of(new IteratorCalculator(), new CalculatorEratosthenes(), 10)
                         );
    }

    @ParameterizedTest
    @MethodSource("changeCalculatorBehaviorGenerator")
    public void changeBehaviorTest(Calculator calculator, CalculatorBehavior calcBehavior, int n) {
        Calculator calc = calculator;
        calc.setCalculatorBehavior(calcBehavior);
        calc.performCalculate(n);
        calc.performShow();
    }
}
