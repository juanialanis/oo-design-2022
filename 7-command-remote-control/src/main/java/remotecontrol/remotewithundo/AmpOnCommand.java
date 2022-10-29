package remotecontrol.remotewithundo;

public class AmpOnCommand implements Command {
	Amplifier amp;
	int volume;

	public AmpOnCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		volume = amp.getVolume();
		amp.on();
	}

	public void undo() {
		amp.off();
		amp.setVolume(volume);
	}
}
