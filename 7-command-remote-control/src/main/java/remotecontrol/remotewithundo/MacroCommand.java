package remotecontrol.remotewithundo;

public class MacroCommand implements Command {

	Command[] commands;

	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	public void execute() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}
	}

	public void undo() {
		// given such a case: macro = {ampOn, setVolume(n)}, we'd like the undo to first
		// un-set the volume and then turn the amp off
		for (int i = commands.length - 1; i >= 0; i--) {
			commands[i].undo();
		}
	}
}
