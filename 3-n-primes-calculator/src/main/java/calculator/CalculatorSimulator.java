package calculator;

public class CalculatorSimulator {
 
	public static void main(String[] args) {
		Calculator calculator = new IteratorCalculator();
    calculator.performCalculate(30);
    // calculator.calculatorBehavior.setShowResultsBehavior(new ShowResultsPrint());
    // calculator.performCalculate(30);
	}

}
