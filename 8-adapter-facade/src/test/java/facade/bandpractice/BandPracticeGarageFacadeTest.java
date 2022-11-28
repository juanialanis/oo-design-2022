package facade.bandpractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(practice.getAmp().getVolume(), 75);
        assertEquals(practice.getLight().getLevel(), 100);
        assertEquals(practice.getFan().getSpeed(), 3);
    }

    @Test
    public void endPraticeTest() {
        BandPracticeGarageFacade practice = new BandPracticeGarageFacade(amp, lights, fan);
        practice.endPractice();
        assertEquals(practice.getAmp().getVolume(), 0);
        assertEquals(practice.getLight().getLevel(), 0);
        assertEquals(practice.getFan().getSpeed(), 0);
    }
}
