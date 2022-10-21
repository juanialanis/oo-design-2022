package calculator;

public class CalculatorSimulator {
 
	public static void main(String[] args) {
		Calculator calculator = new EratosthenesCalculator();
    calculator.setShowResultsBehavior(new ShowResultsFile());
    calculator.performCalculate(25);
    calculator.performShow();
	}

}
