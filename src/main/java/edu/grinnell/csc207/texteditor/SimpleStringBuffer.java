package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    // Store the characters 
    private String buffer;

    // The current position of cursor
    int cursor;

    // Store the number of characters in buffer
    int sz;

    /**
     * Constructor that initializes buffer, cursor position, and the size
     */
    public SimpleStringBuffer(){
        buffer = "";
        cursor = 0;
        sz = 0;
    }

    /**
     * Inserts character ch into the buffer at the cursor's current position, advancing the cursor one position forward.
     * @param ch a character that is inserted into the buffer
     */
    public void insert(char ch) {
        buffer = buffer.substring(0, cursor) + ch + buffer.substring(cursor);
        cursor++;
        sz++;
    }
       
    /**
     * Deletes the character at the cursor's current position, moving the cursor one position backwards. 
     * Does nothing if there are no characters in the buffer.
     */
    public void delete() {
        if (sz != 0 && cursor > 0){
            buffer = buffer.substring(0, cursor - 1) + buffer.substring(cursor);
            cursor--;
            sz--;
        }
    }

    /**
     * 
     * @return the current position of the cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * Moves the cursor one position backwards. The cursor stays put if it is already at the beginning of the buffer.
     */
    public void moveLeft() {
        if (cursor > 0){
            cursor--;
        }
    }

    /**
     * Moves the cursor one position forwards. The cursor stays put if it is already at the end of the buffer.
     */
    public void moveRight() {
        if (cursor < sz){
            cursor++;
        } 
    }

    /**
     * 
     * @return the size of the buffer (the number of the characters in buffer)
     */
    public int getSize() {
        return sz;
    }

    /**
     * 
     * @param i the index of the character in the buffer to get
     * @return the ith character of the buffer, zero-indexed
     * @throws an IndexOutOfBoundsException if i is an invalid index into the buffer
     */
    public char getChar(int i) {
        if (i >= sz){
            throw new IndexOutOfBoundsException();
        } else {
            return buffer.charAt(i);
        }
    }

    @Override
    public String toString() {
        return buffer;
    }
}
