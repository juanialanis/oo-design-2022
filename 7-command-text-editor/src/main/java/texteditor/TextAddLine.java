package texteditor;

import java.util.ArrayList;

public class TextAddLine implements Command {
	Text text;
	int line;
	String sentence;
	ArrayList<String[]> previousText;

	public TextAddLine(Text text, int line, String sentence) {
		this.text = text;
		this.line = line;
		this.sentence = sentence;
	}
 
	public void execute() {
		previousText = (ArrayList<String[]>) text.text.clone();
		text.addLine(line, sentence);
	}
 
	public void undo() {
		text.text = (ArrayList<String[]>) previousText.clone();
	}
}
