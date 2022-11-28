package facade.primesnumber;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;

public class CalculatorTest {

    static Stream<Arguments> primesCalculatorGenerator() {
        return Stream.of(Arguments.of(new CalculatorEratosthenes(), new ShowResultsPrint(), 3),
                Arguments.of(new CalculatorEratosthenes(), new ShowResultsFile(), 5),
                Arguments.of(new CalculatorCheckEach(), new ShowResultsPrint(), 10),
                Arguments.of(new CalculatorCheckEach(), new ShowResultsFile(), 15),
                Arguments.of(new CalculatorEratosthenes(), new ShowResultsPrint(), 20),
                Arguments.of(new CalculatorEratosthenes(), new ShowResultsFile(), 25),
                Arguments.of(new CalculatorCheckEach(), new ShowResultsPrint(), 30),
                Arguments.of(new CalculatorCheckEach(), new ShowResultsFile(), 35));
    }

    @ParameterizedTest
    @MethodSource("primesCalculatorGenerator")
    public void primesTest(CalculatorBehavior calculator, ShowResultsBehavior outputBehavior, int n) {
        Calculator calc = new Calculator(calculator, outputBehavior, n);
        calc.calculateAndShow();
    }

    static Stream<Arguments> changeCalculatorBehaviorGenerator() {
        return Stream.of(Arguments.of(new CalculatorEratosthenes(), new CalculatorCheckEach(), 3),
                Arguments.of(new CalculatorCheckEach(), new CalculatorEratosthenes(), 10));
    }

    @ParameterizedTest
    @MethodSource("changeCalculatorBehaviorGenerator")
    public void changeBehaviorTest(CalculatorBehavior behaviorOne, CalculatorBehavior behaviorTwo, int n) {
        Calculator calc = new Calculator(behaviorOne, new ShowResultsPrint(), n);
        calc.setCalculatorBehavior(behaviorTwo);
        calc.calculateAndShow();
    }

    static Stream<Arguments> changeShowResultsBehaviorGenerator() {
        return Stream.of(Arguments.of(new ShowResultsPrint(), new ShowResultsFile(), 3),
                Arguments.of(new ShowResultsFile(), new ShowResultsPrint(), 10));
    }

    @ParameterizedTest
    @MethodSource("changeShowResultsBehaviorGenerator")
    public void changeBehaviorTest(ShowResultsBehavior behaviorOne, ShowResultsBehavior behaviorTwo, int n) {
        Calculator calc = new Calculator(new CalculatorEratosthenes(), behaviorOne, n);
        calc.setShowResultsBehavior(behaviorTwo);
        calc.performCalculate();
    }

    static Stream<Arguments> calculatorNumbers() {
        return Stream.of(Arguments.of(3), Arguments.of(10), Arguments.of(15), Arguments.of(20), Arguments.of(25),
                Arguments.of(30));
    }

    @ParameterizedTest
    @MethodSource("calculatorNumbers")
    public void casioCalcutorTest(int n) {
        Calculator casio = new CasioCalculator(n);
        casio.performCalculate();
    }

    @ParameterizedTest
    @MethodSource("calculatorNumbers")
    public void tiCalcutorTest(int n) {
        Calculator ti = new TICalculator(n);
        ti.performCalculate();
    }
}
