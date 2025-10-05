package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    private char[] buffer;
    int cursor; //gap start index
    int afterIndex; // after-gap index
    int sz;

    public GapBuffer(){
        buffer = new char[10];
        cursor = 0;
        afterIndex = buffer.length;
        sz = 0;
    }

    public void insert(char ch) {
        if (afterIndex - cursor == 0){
            // Expand the array
            char[] expand = new char[sz * 2];
            System.arraycopy(buffer, 0, expand, 0, cursor);
            System.arraycopy(buffer, afterIndex, expand, sz * 2 - (sz - cursor), sz - afterIndex);
            buffer = expand;
            afterIndex = sz * 2 - (sz - cursor);

            // Insert ch in the gap buffer
            buffer[cursor] = ch;
            cursor++;
            sz++;
        } else {
            buffer[cursor] = ch;
            cursor++;
            sz++;
        }
    }

    public void delete() {
        if (cursor > 0){
            cursor--;
            sz--;
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (cursor > 0){
            cursor--;
            afterIndex--;
            buffer[afterIndex] = buffer[cursor];
        }
    }

    public void moveRight() {
        if (afterIndex < buffer.length){
            buffer[cursor] = buffer[afterIndex];
            cursor++;
            afterIndex++;
        }
    }

    public int getSize() {
        return sz;
    }

    public char getChar(int i) {
        if (i >= sz){
            throw new IndexOutOfBoundsException();
        } else {
            return buffer[i];
        }
    }

    public String toString() {
        String strBefore = new String(buffer,0, cursor);
        String strAfter = new String(buffer, afterIndex, sz - cursor);
        return strBefore + strAfter;
    }
}
