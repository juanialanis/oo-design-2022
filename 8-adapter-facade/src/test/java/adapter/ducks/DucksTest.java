package adapter.ducks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;

public class DucksTest {

    Duck duck;
    Turkey turkey;
    Drone drone;

    @BeforeEach
    public void setUp() {
        duck = new MallardDuck();
        turkey = new WildTurkey();
        drone = new SuperDrone();
    }

    @Test
    public void ducksTest() {
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        Duck droneAdapter = new DroneAdapter(drone);
        DucksAdapter ducks = new DucksAdapter();
        ducks.add(droneAdapter);
        ducks.add(turkeyAdapter);
        ducks.quack();
        ducks.fly();

        Turkey duckAdapter = new DuckAdapter(duck);
        duckAdapter.gobble();
        duckAdapter.fly();
    }
}
