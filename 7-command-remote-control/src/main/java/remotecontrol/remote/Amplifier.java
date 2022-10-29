package remotecontrol.remote;

public class Amplifier {

	String location;

	public Amplifier(String location) {
		this.location = location;

	}

	public void on() {
		System.out.println(location + " amp is on");
	}

	public void off() {
		System.out.println(location + " amp is off");
	}

	public void mute() {
		System.out.println(location + " amp is muted");
	}

	public void setGain(int gain) {
		System.out.println(location + " amp's gain set to " + gain);
	}
}
