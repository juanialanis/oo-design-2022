package remotecontrol.remote;

public class AmpMuteCommand implements Command {
	Amplifier amp;

	public AmpMuteCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		amp.mute();
	}
}
