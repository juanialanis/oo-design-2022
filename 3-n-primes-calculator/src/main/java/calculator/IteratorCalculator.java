package calculator;

public class IteratorCalculator extends Calculator {

	public IteratorCalculator() {
    calculatorBehavior = new CalculatorCheckEach();
    showResultsBehavior = new ShowResultsPrint();
	}

}
