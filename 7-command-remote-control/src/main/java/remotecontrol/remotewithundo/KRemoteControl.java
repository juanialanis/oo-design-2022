package remotecontrol.remotewithundo;

import java.util.EmptyStackException;
import java.util.Stack;

//
// This is the invoker
//
public class KRemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	Command noCommand;

	Stack<Command> undos;
	Stack<Command> redos;

	int k;

	public KRemoteControl(int k) {
		onCommands = new Command[7];
		offCommands = new Command[7];
		noCommand = new NoCommand();

		undos = new Stack<Command>();
		redos = new Stack<Command>();

		this.k = k;

		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		// whenver it reaches 7 elements, start deleting the oldest every time
		if (undos.size() >= this.k) {
			undos.remove(0);
		}
		undos.push(onCommands[slot]);
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		// whenver it reaches k elements, start deleting the oldest every time
		// (not quite stack behavior, but it's what actually need)
		if (undos.size() >= this.k) {
			undos.remove(0);
		}
		undos.push(offCommands[slot]);
	}

	public void undoButtonWasPushed() {
		try {
			Command undoCommand = undos.pop();
			undoCommand.undo();
			// whenver it reaches k elements, start deleting the oldest every time
			// (not quite stack behavior, but it's what we actually need)
			if (redos.size() >= this.k) {
				redos.remove(0);
			}
			redos.push(undoCommand);
		} catch (EmptyStackException e) {
			// after running out of undos, don't do anything!
			noCommand.execute();
		}
	}

	public void redoButtonWasPushed() {
		try {
			Command redoCommand = redos.pop();
			redoCommand.execute();
		} catch (EmptyStackException e) {
			// after running out of redos, don't do anything!
			noCommand.execute();
		}
	}
}
