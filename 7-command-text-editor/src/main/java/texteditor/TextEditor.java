package texteditor;

import java.util.EmptyStackException;
import java.util.Stack;

public class TextEditor {
	Command[] shortcuts;
	
	Stack<Command> undos;
	Stack<Command> redos;

	int k;


	public TextEditor(int k) {
		shortcuts = new Command[7];
		Command noCommand = new NoCommand();
 
		for(int i=0;i<7;i++) {
			shortcuts[i] = noCommand;
		}

		undos = new Stack<Command>();
		redos = new Stack<Command>();

		this.k = k;

	}
  
	public void setCommand(int slot, Command onCommand) {
		shortcuts[slot] = onCommand;
	}
 
	public void ButtonWasPushed(int slot) {
		shortcuts[slot].execute();
			// whenver it reaches k elements, start deleting the oldest every time
			if (undos.size() >= this.k) {
				undos.remove(0);
			}
			undos.push(shortcuts[slot]);
	
	}
  
	public void undoButtonWasPushed() {
		Command noCommand = new NoCommand();
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
		Command noCommand = new NoCommand();
		try {
			Command redoCommand = redos.pop();
			redoCommand.execute();
			undos.push(redoCommand);
		} catch (EmptyStackException e) {
			// after running out of redos, don't do anything!
			noCommand.execute();
		}
	}

 
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Text Editor Shortcuts -------\n");
		for (int i = 0; i < shortcuts.length; i++) {
			stringBuff.append("[slot " + i + "] " + shortcuts[i].getClass().getName()+ "\n");
		}
		stringBuff.append("[undo] " + undos.getClass().getName() + "\n");
		return stringBuff.toString();
	}
}
