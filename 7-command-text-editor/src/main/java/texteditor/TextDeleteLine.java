package texteditor;

import java.util.ArrayList;

public class TextDeleteLine implements Command {
	Text text;
	int line;
	ArrayList<String[]> previousText;

	public TextDeleteLine(Text text, int line) {
		this.text = text;
		this.line = line;
	}
 
	public void execute() {
		previousText = (ArrayList<String[]>) text.text.clone();
		text.deleteLine(line);
	}
	
	public void undo() {
		text.text = (ArrayList<String[]>) previousText.clone();
	}
}
