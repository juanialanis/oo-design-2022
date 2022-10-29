package remotecontrol.remote;

public class AmpSetGainCommand implements Command {
	Amplifier amp;
	int gain;

	public AmpSetGainCommand(Amplifier amp, int gain) {
		this.amp = amp;
		this.gain = gain;
	}

	public void execute() {
		amp.setGain(gain);
	}
}
