package facade.primesnumber;

public class TICalculator extends Calculator {
  public TICalculator(int n){
    super(new CalculatorCheckEach(), new ShowResultsFile(), n);
  }
}
