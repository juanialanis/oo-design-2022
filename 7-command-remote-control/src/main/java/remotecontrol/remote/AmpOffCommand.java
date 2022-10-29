package remotecontrol.remote;

public class AmpOffCommand implements Command {
	Amplifier amp;

	public AmpOffCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		amp.off();
	}
}
