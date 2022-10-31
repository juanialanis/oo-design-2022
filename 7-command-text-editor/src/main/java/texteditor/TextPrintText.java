package texteditor;

public class TextPrintText implements Command {
	Text text;

	public TextPrintText(Text text) {
		this.text = text;
	}
 
	public void execute() {
		text.printText();
	}
	
	public void undo() { }
}
