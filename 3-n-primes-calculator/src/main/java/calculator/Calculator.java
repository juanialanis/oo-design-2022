package calculator;

public abstract class Calculator {

	CalculatorBehavior calculatorBehavior;
  //El show results deberia ir en la clase CalculatorBehavior para poder usarlo en cada implementacion distinta de calculadora
  //pero en este momento es una interface por lo que no puedo agregarla.
	public Calculator() {
	}

	public void setCalculatorBehavior(CalculatorBehavior cb) {
		calculatorBehavior = cb;
	}

	public void performCalculate(int n) {
		calculatorBehavior.calculate(n);
	}

}
