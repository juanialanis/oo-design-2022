package remotecontrol.remotewithundo;

public class AmpMuteCommand implements Command {

	Amplifier amp;
	int volume;

	public AmpMuteCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		volume = amp.getVolume();
		amp.mute();
	}

	public void undo() {
		amp.setVolume(volume);
	}
}
