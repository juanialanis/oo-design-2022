package calculator;

import java.util.Arrays;

public class CalculatorErasthotenes extends CalculatorBehavior{
  
  public void calculate(int n) {
    boolean prime[] = new boolean[n + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p * p <= n; p++) {
      if (prime[p]) {
        for (int i = p * 2; i <= n; i += p) {
          prime[i] = false;
        }
      }
    }
    for (int i = 2; i <= n; i++) {
      if (prime[i]) {
        showResultsBehavior.show(i);
      }
    }
  }
}
