package calculator;

import java.util.List;

public abstract class Calculator {

	List<Integer> result;
	CalculatorBehavior calculatorBehavior;
	ShowResultsBehavior showResultsBehavior;


	public void setCalculatorBehavior(CalculatorBehavior behavior) {
		calculatorBehavior = behavior;
	}

	public void performCalculate(int n) {
		result = calculatorBehavior.calculate(n);
	}

	public void setShowResultsBehavior(ShowResultsBehavior behavior) {
		showResultsBehavior = behavior;
	}

	public void performShow() {
		showResultsBehavior.show(result);
	}
}
