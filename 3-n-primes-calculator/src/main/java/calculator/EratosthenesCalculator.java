package calculator;

public class EratosthenesCalculator extends Calculator{
  public EratosthenesCalculator() {
    CalculatorBehavior cb = new CalculatorErasthotenes();
    cb.setShowResultsBehavior(new ShowResultsFile());
    calculatorBehavior = cb;
	}
}
