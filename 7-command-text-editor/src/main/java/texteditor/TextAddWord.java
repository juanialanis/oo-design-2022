package texteditor;

import java.util.ArrayList;

public class TextAddWord implements Command {
	Text text;
	int line;
	int index;
	String sentence;
	ArrayList<String[]> previousText;

	public TextAddWord(Text text, int line, int index, String sentence) {
		this.text = text;
		this.line = line;
		this.index = index;
		this.sentence = sentence;
	}
 
	public void execute() {
		previousText = (ArrayList<String[]>) text.text.clone();
		text.addWord(line,index, sentence);
	}
 
	public void undo() {
		text.text = (ArrayList<String[]>) previousText.clone();
	}
}
