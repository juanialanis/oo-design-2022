package calculator;

public class IteratorCalculator extends Calculator {

	public IteratorCalculator() {
    CalculatorBehavior cb = new CalculatorCheckEach();
    cb.setShowResultsBehavior(new ShowResultsFile());
    calculatorBehavior = cb;
	}

}
