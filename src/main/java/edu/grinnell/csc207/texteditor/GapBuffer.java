package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    // Gap buffer
    private char[] buffer;

    // Start-of-gap index
    int cursor;
    // After-gap index
    int afterIndex;

    // Number of elements in the buffer (excluding the gap)
    int sz;

    /**
     * Constructor that initialize the buffer, cursor, afterIndex, and sz
     * Initialize buffer to a character array with a length of 10, making all of them as the gap
     */
    public GapBuffer() {
        buffer = new char[10];
        cursor = 0;
        afterIndex = buffer.length;
        sz = 0;
    }

    /**
     * Insert a character to the buffer at cursor (start of the gap)
     * @param ch a character that is inserte to the buffer
     */
    public void insert(char ch) {
        if (cursor == afterIndex) {
            // Expand the array
            int newLength = buffer.length * 2;
            int newAfterIndex = newLength - (buffer.length - afterIndex);
            char[] expand = new char[newLength];
            System.arraycopy(buffer, 0, expand, 0, cursor);
            System.arraycopy(buffer, afterIndex, expand, newAfterIndex, buffer.length - afterIndex);

            afterIndex = newAfterIndex;
            buffer = expand;

            // Insert ch in the gap buffer
            buffer[cursor] = ch;
            cursor++;
            sz++;
        } else {
            // Insert ch in the gap buffer
            buffer[cursor] = ch;
            cursor++;
            sz++;
        }
    }

    /**
     * Move the cursor (start index) of the gap to the left by one
     */
    public void delete() {
        if (cursor > 0) {
            cursor--;
            sz--;
        }
    }

    /**
     * Get the current cursor position, which is a start index of the gap
     * @return the current position of the cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * Move the end character of the left section to the start of the right section, and 
     * move the start and end point of the gap (cursor and afterIndex) to the left by one 
     */
    public void moveLeft() {
        if (cursor > 0) {
            cursor--;
            afterIndex--;
            buffer[afterIndex] = buffer[cursor];
        }
    }

    /**
     * Move the start character of the right section to the end of the left section, and 
     * move the start and end point of the gap (cursor and afterIndex) to the right by one 
     */
    public void moveRight() {
        if (afterIndex < buffer.length) {
            buffer[cursor] = buffer[afterIndex];
            cursor++;
            afterIndex++;
        }
    }

    /**
     * Get the number of characters in the buffer
     * @return the current number of elements in the buffer
     */
    public int getSize() {
        return sz;
    }

    /**
     * Get the character at index i
     * @param i the index of the buffer to get the character of
     * @return a character at index i of the buffer
     */
    public char getChar(int i) {
        if (i >= sz) {
            throw new IndexOutOfBoundsException();
        } else if (i < cursor) {
            return buffer[i];
        } else {
            return buffer[i + (afterIndex - cursor)];
        }
    }

    /**
     * Make the buffer (a character array) to a complete string
     * @return a string made of characters in the buffer outside of the gap
     */
    public String toString() {
        String strBefore = new String(buffer, 0, cursor);
        String strAfter = new String(buffer, afterIndex, sz - cursor);
        return strBefore + strAfter;
    }
}