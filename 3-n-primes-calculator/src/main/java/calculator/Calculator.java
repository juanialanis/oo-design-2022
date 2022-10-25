package calculator;

import java.util.List;

public class Calculator {

    List<Integer> result;
    CalculatorBehavior calculatorBehavior;
    ShowResultsBehavior showResultsBehavior;
    int number;

    public Calculator(CalculatorBehavior calculatorBehavior, ShowResultsBehavior showBehavior, int n) {
        this.calculatorBehavior = calculatorBehavior;
        this.showResultsBehavior = showBehavior;
        number = n;
    }

    public void setCalculatorBehavior(CalculatorBehavior behavior) {
        calculatorBehavior = behavior;
    }

    public void performCalculate() {
        result = calculatorBehavior.calculate(number);
    }

    public void setShowResultsBehavior(ShowResultsBehavior behavior) {
        showResultsBehavior = behavior;
    }

    public void performShow() {
        showResultsBehavior.show(result);
    }

    public void calculateAndShow() {
        this.performCalculate();
        this.performShow();
    }
}
