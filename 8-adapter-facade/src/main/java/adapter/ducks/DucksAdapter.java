package adapter.ducks;

import java.util.ArrayList;
import java.util.List;

public class DucksAdapter implements Ducks {
	List<Duck> ducks;
 
	public DucksAdapter() {
		this.ducks = new ArrayList<>();
	}

  public void add(Duck duck){
    this.ducks.add(duck);
  }
    
	public void quack() {
		for(Duck duck: this.ducks){
      duck.quack();
    }
	}
  
	public void fly() {
		for(Duck duck: this.ducks){
      duck.fly();
    }
	}
}
