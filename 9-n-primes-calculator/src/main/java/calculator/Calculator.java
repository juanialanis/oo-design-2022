package calculator;

import java.util.List;

public abstract class Calculator {

  final void calculate(int n) {
    List<Integer> results = calculateNumbers(n);
    showNumbers(results);
  }

  abstract List<Integer> calculateNumbers(int n);

  abstract void showNumbers(List<Integer> results);
}
