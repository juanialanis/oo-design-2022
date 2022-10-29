package remotecontrol.remotewithundo;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

		Light livingRoomLight = new Light("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		Amplifier amp = new Amplifier("Garage");
		AmpOnCommand ampOn = new AmpOnCommand(amp);
		AmpOffCommand ampOff = new AmpOffCommand(amp);

		remoteControl.setCommand(0, ampOn, ampOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		Light garageLight = new Light("Garage Room");
		LightOnCommand garageLightOn = new LightOnCommand(garageLight);
		LightOffCommand garageLightOff = new LightOffCommand(garageLight);
		CeilingFan garageCeilingFan = new CeilingFan("Garage");
		CeilingFanMediumCommand garageCeilingFanMedium = new CeilingFanMediumCommand(garageCeilingFan);
		CeilingFanOffCommand garageCeilingFanOff = new CeilingFanOffCommand(garageCeilingFan);

		Command[] garagePracticeStart = { garageLightOn, garageCeilingFanMedium, ampOn };
		Command[] garagePracticeFinish = { garageLightOff, garageCeilingFanOff, ampOff };

		MacroCommand garagePracticeStartMacro = new MacroCommand(garagePracticeStart);
		MacroCommand garagePracticeFinishMacro = new MacroCommand(garagePracticeFinish);

		remoteControl.setCommand(0, garagePracticeStartMacro, garagePracticeFinishMacro);

		System.out.println("******* MACRO *******");

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
