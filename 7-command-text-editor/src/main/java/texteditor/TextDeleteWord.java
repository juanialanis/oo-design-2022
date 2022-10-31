package texteditor;

import java.util.ArrayList;

public class TextDeleteWord implements Command {
	Text text;
	int line;
	int index;
	ArrayList<String[]> previousText;

	public TextDeleteWord(Text text, int line, int index) {
		this.text = text;
		this.line = line;
		this.index = index;
	}
 
	public void execute() {
		previousText = (ArrayList<String[]>) text.text.clone();
		text.deleteWord(line,index);
	}
 
	public void undo() {
		text.text = (ArrayList<String[]>) previousText.clone();
	}
}
