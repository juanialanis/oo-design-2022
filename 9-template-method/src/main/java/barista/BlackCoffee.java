package barista;

public class BlackCoffee extends CaffeineBeverage {
	
  public void brew() {
		System.out.println("Dripping Black Coffee through filter");
	}

	public void addCondiments(){
    
  }

	public boolean customerWantsCondiments() {
		return false;
	}
}
