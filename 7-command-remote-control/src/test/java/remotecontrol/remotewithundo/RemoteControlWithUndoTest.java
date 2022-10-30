package remotecontrol.remotewithundo;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RemoteControlWithUndoTest {

    RemoteControlWithUndo remoteControl;

    Light garageLight;
    LightOnCommand garageLightOn;
    LightOffCommand garageLightOff;

    Light bedroomLight;
    DimmerLightOnCommand bedroomLightOn;
    DimmerLightOffCommand bedroomLightOff;

    CeilingFan ceilingFan;
    CeilingFanMediumCommand ceilingFanMedium;
    CeilingFanHighCommand ceilingFanHigh;
    CeilingFanLowCommand ceilingFanLow;
    CeilingFanOffCommand ceilingFanOff;

    Amplifier amp;
    AmpOnCommand ampOn;
    AmpOffCommand ampOff;

    @BeforeEach
    public void setUpLights() {
        garageLight = new Light("Garage");
        garageLightOn = new LightOnCommand(garageLight);
        garageLightOff = new LightOffCommand(garageLight);
    }

    @BeforeEach
    void setUpDimmerLights() {
        bedroomLight = new Light("Bedroom");
        bedroomLightOn = new DimmerLightOnCommand(bedroomLight);
        bedroomLightOff = new DimmerLightOffCommand(bedroomLight);
    }

    @BeforeEach
    public void setUpCeilingFan() {
        ceilingFan = new CeilingFan("Garage");
        ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
    }

    @BeforeEach
    public void setUpAmp() {
        amp = new Amplifier("Garage");
        ampOn = new AmpOnCommand(amp);
        ampOff = new AmpOffCommand(amp);
    }

    @BeforeEach
    public void setUpRemote() {
        remoteControl = new RemoteControlWithUndo();
    }

    @Test
    public void lightsTest() {
        remoteControl.setCommand(0, garageLightOn, garageLightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
    }

    @Test
    public void dimmerLightsTest() {
        remoteControl.setCommand(0, bedroomLightOn, bedroomLightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
    }

    @ParameterizedTest
    @CsvSource({ "0, 0", "0, 1", "0, 2", "1, 0", "1, 1", "1, 2", "2, 0", "2, 1", "2, 2" })
    public void ceilingFanTest(int speed, int prev) {
        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanLow, ceilingFanOff);

        remoteControl.onButtonWasPushed(prev);
        remoteControl.onButtonWasPushed(speed);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(prev);
        remoteControl.offButtonWasPushed(speed);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(prev);
        remoteControl.onButtonWasPushed(speed);
        remoteControl.undoButtonWasPushed();
    }

    @Test
    public void ampTest() {
        remoteControl.setCommand(0, ampOn, ampOff);
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
    }

    @Test
    public void garagePracticeTest() {
        Command[] garagePracticeStart = { garageLightOn, ceilingFanMedium, ampOn };
        Command[] garagePracticeFinish = { garageLightOff, ceilingFanOff, ampOff };

        MacroCommand garagePracticeStartMacro = new MacroCommand(garagePracticeStart);
        MacroCommand garagePracticeFinishMacro = new MacroCommand(garagePracticeFinish);

        remoteControl.setCommand(0, garagePracticeStartMacro, garagePracticeFinishMacro);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
