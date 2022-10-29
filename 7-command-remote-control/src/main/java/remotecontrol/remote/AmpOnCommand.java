package remotecontrol.remote;

public class AmpOnCommand implements Command {
	Amplifier amp;

	public AmpOnCommand(Amplifier amp) {
		this.amp = amp;
	}

	public void execute() {
		amp.on();
	}
}
