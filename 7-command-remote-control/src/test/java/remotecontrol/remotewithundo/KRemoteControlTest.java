package remotecontrol.remotewithundo;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class KRemoteControlTest {

    Light livingRoomLight;
    LightOnCommand livingRoomLightOn;
    LightOffCommand livingRoomLightOff;

    @BeforeEach
    public void setUp() {
        livingRoomLight = new Light("Living Room");
        livingRoomLightOn = new LightOnCommand(livingRoomLight);
        livingRoomLightOff = new LightOffCommand(livingRoomLight);
    }

    @ParameterizedTest
    @CsvSource({ "2", "3", "5", "6" })
    public void kRemoteTest(int k) {
        KRemoteControl remote = new KRemoteControl(k);
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);

        remote.undoButtonWasPushed();
        remote.undoButtonWasPushed();
        remote.undoButtonWasPushed();
        remote.undoButtonWasPushed();

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);

        remote.undoButtonWasPushed();
        remote.undoButtonWasPushed();

        remote.redoButtonWasPushed();
        remote.redoButtonWasPushed();
        remote.redoButtonWasPushed();
        remote.redoButtonWasPushed();
    }
}
