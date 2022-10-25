package calculator;

import calculator.Calculator;
import calculator.CalculatorCheckEach;
import calculator.CalculatorEratosthenes;

public class CalculatorSimulator {
  public static void main(String[] args) {
    Calculator c = new CalculatorCheckEach();
    c.calculate(10);
    c = new CalculatorEratosthenes();
    c.calculate(10);
  }
}
