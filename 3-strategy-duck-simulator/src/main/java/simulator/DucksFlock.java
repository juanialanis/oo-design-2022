package simulator;

import java.util.List;
import java.util.ArrayList;

public class DucksFlock {
  private List<Duck> ducks;

	public DucksFlock() {
    ducks = new ArrayList<Duck>();
	}

	public void display() {
		System.out.println("I'm a duck flock");
	}

  public void add(Duck d){
    ducks.add(d);
  }

  public void fly() {
    for(Duck d: ducks){
		  d.flyBehavior.fly();
    }
	}

	public void quack() {
    for(Duck d: ducks){
		  d.quackBehavior.quack();
    }
	}
}
