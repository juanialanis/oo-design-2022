package texteditor;

import java.util.Scanner;

public class TextEditorTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		TextEditor textEditor = new TextEditor(10);
		Text text = new Text();
		int line, index, option;
		String sentence, word;
		while (true) {

			System.out.println("\n******Menu Options******");
			System.out.println("\n0-Exit 1-Add Line  2-Delete Line   3-Show Text    4-Add word to a Line    5-Delete word from a Line   6-Undo   7-Redo");
	
			option = Integer.parseInt(scanner.nextLine());
			
			switch(option) {
				case 1:
					System.out.println("\n******Adding a Line******");
					System.out.println("Enter the line: ");
					line = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter the sentence: ");
					sentence = scanner.nextLine();
					TextAddLine textAddText = new TextAddLine(text, line, sentence);
					textEditor.setCommand(0, textAddText);        
					textEditor.ButtonWasPushed(0);
				  break;
				case 2:
					System.out.println("\n******Deleting a Line******");
					System.out.println("Enter the line: ");
					line = Integer.parseInt(scanner.nextLine());
					TextDeleteLine textDeleteText = new TextDeleteLine(text, line);
					textEditor.setCommand(0, textDeleteText);        
					textEditor.ButtonWasPushed(0);
				  break;
				case 3:
					System.out.println("\n******Showing the text******\n");
					TextPrintText textPrintText = new TextPrintText(text);
					textEditor.setCommand(0, textPrintText);        
					textEditor.ButtonWasPushed(0);
				  break;
				case 4:
					System.out.println("\n******Adding a Word******");
					System.out.println("Enter the line: ");
					line = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter the index: ");
					index = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter the word: ");
					word = scanner.nextLine();
					TextAddWord textAddWord = new TextAddWord(text, line, index, word);
					textEditor.setCommand(0, textAddWord);        
					textEditor.ButtonWasPushed(0);
				  break;
				case 5:
					System.out.println("\n******Deleting a Word******");
					System.out.println("Enter the line: ");
					line = Integer.parseInt(scanner.nextLine());
					System.out.println("Enter the index: ");
					index = Integer.parseInt(scanner.nextLine());
					TextDeleteWord textDeleteWord = new TextDeleteWord(text, line, index);
					textEditor.setCommand(0, textDeleteWord);        
					textEditor.ButtonWasPushed(0);
				  break;
				case 6:
					textEditor.undoButtonWasPushed();
				  break;
				case 7:
					textEditor.redoButtonWasPushed();
				  break;
				default:
					System.out.println("Invalid Option");
			  }
			if (option == 0) {
				break;
			}
		}
		scanner.close();
    }
	
}
