package texteditor;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class TextEditorTest {
    static Text text = new Text();

    static Stream<Arguments> generator() {;
        return Stream.of(
            Arguments.of(new TextEditor(10), new TextAddLine(text, 1, "Hello World"), 1, "Hello World"),
            Arguments.of(new TextEditor(10), new TextDeleteLine(text, 1), 1, "Nullam consectetur, lacus ut aliquet imperdiet, diam nulla maximus nulla, vel vestibulum justo lectus quis ipsum. Donec ullamcorper aliquet tincidunt. Proin elementum vestibulum diam, nec commodo neque. Integer dolor mauris, auctor ac viverra vel, sagittis eget magna. Etiam euismod quam a mi semper, in mattis elit tempor. Curabitur orci sapien, dictum vitae erat elementum, varius faucibus magna. Aliquam pharetra lorem et orci vestibulum ultrices. Pellentesque at nibh eu mi dapibus mollis eget vitae felis. Etiam condimentum ante id metus vulputate, vitae laoreet dui eleifend. Vivamus scelerisque congue turpis ut faucibus. Praesent a lorem congue, porttitor nunc eget, molestie elit. Phasellus cursus nisl ipsum, et convallis justo semper non. Nulla aliquam enim id elit maximus, id mollis ligula mattis. Proin pharetra sodales vehicula."),
            Arguments.of(new TextEditor(10), new TextAddWord(text, 1,0,"Hello"), 1, "Hello Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat volutpat. Mauris eu tempor nibh, vitae interdum ante. Phasellus sagittis enim metus. Morbi consectetur nec justo eu molestie. Phasellus gravida, purus et mattis pellentesque, mauris augue malesuada diam, et efficitur tortor arcu quis felis. Quisque quis consectetur ex. Pellentesque tincidunt nisi eleifend sapien euismod euismod. Quisque sed elit nisi. Duis ut leo luctus, egestas nisi ut, consectetur lectus. Maecenas ac ornare eros, ac scelerisque enim. Proin suscipit, arcu id porta elementum, mauris est rhoncus orci, a laoreet magna nisl in dui."),
            Arguments.of(new TextEditor(10), new TextDeleteWord(text, 1,0), 1, "ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat volutpat. Mauris eu tempor nibh, vitae interdum ante. Phasellus sagittis enim metus. Morbi consectetur nec justo eu molestie. Phasellus gravida, purus et mattis pellentesque, mauris augue malesuada diam, et efficitur tortor arcu quis felis. Quisque quis consectetur ex. Pellentesque tincidunt nisi eleifend sapien euismod euismod. Quisque sed elit nisi. Duis ut leo luctus, egestas nisi ut, consectetur lectus. Maecenas ac ornare eros, ac scelerisque enim. Proin suscipit, arcu id porta elementum, mauris est rhoncus orci, a laoreet magna nisl in dui.")

        );
    }     

    @ParameterizedTest
    @MethodSource("generator")
    public void commandsTest(TextEditor textEditor, Command command, int line, String sentence) {
        String previous = text.getLine(line);
        textEditor.setCommand(0, command);
        textEditor.ButtonWasPushed(0);
        assertEquals(sentence, text.getLine(line));
        textEditor.undoButtonWasPushed();
        assertEquals(previous, text.getLine(line));
    }


    @Test
    public void textPrintTest() {
        TextEditor textEditor = new TextEditor(10);
        TextPrintText textPrintText = new TextPrintText(text);
        textEditor.setCommand(0, textPrintText);
        textEditor.ButtonWasPushed(0);
    }

    @Test
    public void undoAndRedotTest() {
        TextEditor textEditor = new TextEditor(3);
        Text textUndo = new Text();
        TextAddLine textAddText;
        int amountLines = textUndo.countLines();
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        assertEquals(textUndo.countLines(), amountLines + 7);
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();   
        assertEquals(textUndo.countLines(), amountLines + 4);
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        assertEquals(textUndo.countLines(), amountLines + 7);
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        assertEquals(textUndo.countLines(), amountLines + 5);
    }



    @Test
    public void multiplesUndoAndRedotTest() {
        TextEditor textEditor = new TextEditor(3);
        Text textUndo = new Text();
        TextAddLine textAddText;
        int amountLines = textUndo.countLines();
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        assertEquals(textUndo.countLines(), amountLines + 4);
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();   
        assertEquals(textUndo.countLines(), amountLines + 1);

        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textEditor.undoButtonWasPushed();
        textEditor.undoButtonWasPushed();   


        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        textEditor.redoButtonWasPushed();
        assertEquals(textUndo.countLines(), amountLines + 4);

        textAddText = new TextAddLine(textUndo, 1, "Hello World");
        textEditor.setCommand(0, textAddText);        
        textEditor.ButtonWasPushed(0);
        textAddText = new TextAddLine(textUndo, 1, "Hello World");




    }


}
