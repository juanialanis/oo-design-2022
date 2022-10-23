package calculator;

public class EratosthenesCalculator extends Calculator{
  public EratosthenesCalculator() {
    calculatorBehavior = new CalculatorEratosthenes();
    showResultsBehavior = new ShowResultsFile();
	}
}
