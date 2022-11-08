package facade.bandpractice;

public class Amplifier {

	String location;
	int volume;

	public Amplifier(String location) {
		this.location = location;

	}

	public void on() {
		volume = 100;
		System.out.println(location + " amp is on");
	}

	public void off() {
		volume = 0;
		System.out.println(location + " amp is off");
	}

	public void setVolume(int volume) {
		this.volume = volume;
		if (volume == 0) {
			off();
		} else {
			System.out.println("Volume is set to " + volume + "%");
		}

	}

	public int getVolume() {
		return volume;
	}
}
