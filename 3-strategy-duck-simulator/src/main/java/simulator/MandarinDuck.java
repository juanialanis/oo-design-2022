package simulator;

public class MandarinDuck extends Duck {

	public MandarinDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("I'm a real Mandarin duck");
	}

}
