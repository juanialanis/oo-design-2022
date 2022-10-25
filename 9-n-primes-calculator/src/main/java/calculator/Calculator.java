package calculator;

import java.util.List;

public abstract class Calculator {

  final void calculate(int n) {
		List<Integer> results = calculateNumbers(n);
		showNumbers(results);
	}

	public abstract List<Integer> calculateNumbers(int n);

  public abstract void showNumbers(List<Integer> results);
}
