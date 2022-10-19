package simulator;

public class DuckSimulator {
 
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
   
		Duck model = new ModelDuck();
		model.setFlyBehavior(new FlyRocketPowered());
    
    Duck m = new MallardDuck();
    m.setFlyBehavior(new FlyWithMagicBroom());
    m.setQuackBehavior(new QuackWithMegaphone());

    Duck mandarin = new MandarinDuck();

    DucksFlock d = new DucksFlock();
    d.add(mallard);
    d.add(model);
    d.add(m);
    d.add(mandarin);
    d.fly();
    d.quack();
	}

}
