package calculator;

public class EratosthenesCalculator extends Calculator{
  public EratosthenesCalculator() {
    calculatorBehavior = new CalculatorErasthotenes();
    showResultsBehavior = new ShowResultsFile();
	}
}
