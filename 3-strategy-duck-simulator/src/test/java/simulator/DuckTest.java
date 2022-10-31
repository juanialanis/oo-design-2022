package simulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DuckTest {

    @Test
    public void testScenario() {
        Duck mallard = new MallardDuck();
        mallard.setFlyBehavior(new FlyNoWay());

        Duck model = new ModelDuck();
        model.setFlyBehavior(new FlyRocketPowered());
        model.setQuackBehavior(new QuackWithStereo());

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
