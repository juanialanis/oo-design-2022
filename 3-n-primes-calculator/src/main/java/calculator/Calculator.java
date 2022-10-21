package calculator;

import java.util.List;

public abstract class Calculator {

  List<Integer> result;
	CalculatorBehavior calculatorBehavior;
  ShowResultsBehavior showResultsBehavior;

	public Calculator() {
	}

	public void setCalculatorBehavior(CalculatorBehavior cb) {
		calculatorBehavior = cb;
	}

	public void performCalculate(int n) {
		result = calculatorBehavior.calculate(n);
	}

  public void setShowResultsBehavior(ShowResultsBehavior srb) {
		showResultsBehavior = srb;
	}

	public void performShow() {
		showResultsBehavior.show(result);
	}
}
