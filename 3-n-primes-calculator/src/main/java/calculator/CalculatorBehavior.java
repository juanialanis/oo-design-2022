package calculator;
public abstract class CalculatorBehavior {
	ShowResultsBehavior showResultsBehavior;

  public abstract void calculate(int n);


  public void setShowResultsBehavior(ShowResultsBehavior srb) {
		showResultsBehavior = srb;
	}

	public void performShow(int n) {
		showResultsBehavior.show(n);
	}
}
