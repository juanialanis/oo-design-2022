package facade.primesnumber;

public class CasioCalculator extends Calculator {
  public CasioCalculator(int n){
    super(new CalculatorEratosthenes(), new ShowResultsPrint(), n);
  }
}
