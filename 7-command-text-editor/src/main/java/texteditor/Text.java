package texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text {
	ArrayList<String[]> text;

	public Text() {
		this.text = new ArrayList<>();
		loadText();
	}

	private void loadText() {
		try {	
			File file = new File("LoremIpsum.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;  
			while((line = br.readLine())!=null) {  
				String[] split = line.split(" ");
				this.text.add(split);
			}  
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addLine(int line, String sentence) {
		String[] string = sentence.split(" ");
		text.add(line,string);
	}

	public void deleteLine(int line) {
		text.remove(line);
	}

	public void addWord(int line, int index, String word) {
		List<String> list = new ArrayList<>(Arrays.asList(text.get(line)));
        list.add(index, word);
		text.set(line, list.toArray(new String[list.size()]));
	}

	public void deleteWord(int line, int index) {
		List<String> list = new ArrayList<>(Arrays.asList(text.get(line)));
        list.remove(index);
		text.set(line, list.toArray(new String[list.size()]));
	}
	
	public String getLine(int line) {
		String string = "";
		for (String word : text.get(line)) {
			string += word + " ";
		}
		return string.substring(0, string.length() - 1);
	}

	public int countLines() {
		return text.size();
	}

	public void printText() {
		StringBuffer stringBuff = new StringBuffer();
		for (String[] line : text) {
			for (String word : line) {
				stringBuff.append(word + " ");	
			}
			stringBuff.append("\n");	
		}
		System.out.println(stringBuff.toString());
	}

}
