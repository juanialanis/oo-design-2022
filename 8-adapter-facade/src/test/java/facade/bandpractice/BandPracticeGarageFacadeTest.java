package facade.bandpractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BandPracticeGarageFacadeTest {

    Amplifier amp;
    Light lights;
    CeilingFan fan;

    @BeforeEach
    public void setUp() {
        amp = new Amplifier("Garage");
        lights = new Light("Garage");
        fan = new CeilingFan("Garage");
    }

    @Test
    public void startPraticeTest() {
        BandPracticeGarageFacade practice = new BandPracticeGarageFacade(amp, lights, fan);
        practice.startPractice();
    }

    @Test
    public void endPraticeTest() {
        BandPracticeGarageFacade practice = new BandPracticeGarageFacade(amp, lights, fan);
        practice.endPractice();
    }
}
