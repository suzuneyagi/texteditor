package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException{
        screen.clear();

        for (int i = 0; i < buf.getSize(); i++){
            TextCharacter ch = TextCharacter.fromCharacter(buf.getChar(i))[0];
            screen.setCharacter(i, 0, ch);
        }
        screen.refresh();
    }

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException {
        // if (args.length != 1) {
        //     System.err.println("Usage: java TextEditor <filename>");
        //     System.exit(1);
        // }

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        Screen screen = factory.createScreen();
        screen.startScreen();

        GapBuffer buf = new GapBuffer();
        buf.insert('H');
        buf.insert('e');
        buf.insert('l');
        buf.insert('l');
        buf.insert('o');

        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            KeyType type = stroke.getKeyType();
            if (type == KeyType.Character){
                buf.insert(stroke.getCharacter());
            } else if (type == KeyType.ArrowLeft){
                buf.moveLeft();
            } else if (type == KeyType.ArrowRight){
                buf.moveRight();
            } else if (type == KeyType.Backspace){
                buf.delete();
            } else if (type == KeyType.Escape){
                isRunning = false;
            }
            drawBuffer(buf, screen);
        }

        // String path = args[0];
        // System.out.format("Loading %s...\n", path);

        screen.stopScreen();
    }
}
