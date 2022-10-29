package remotecontrol.remotewithundo;

public class AmpOffCommand implements Command {
	Amplifier amp;
	int volume;

	public AmpOffCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		volume = amp.getVolume();
		amp.off();
	}

	public void undo() {
		amp.on();
		amp.setVolume(volume);
	}
}
