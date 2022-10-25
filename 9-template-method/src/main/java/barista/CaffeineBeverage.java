package barista;

public abstract class CaffeineBeverage {
  
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
    // Para inciso b
    if (customerWantsCondiments()){
      addCondiments();
    }
    // Para inciso a
    // addCondiments();
	}
 
	abstract void brew();
  
	abstract void addCondiments();

  boolean customerWantsCondiments(){
    return true;
  }
 
	void boilWater() {
		System.out.println("Boiling water");
	}
  
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
}
