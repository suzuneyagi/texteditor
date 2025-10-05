# CSC 207: Text Editor

**Author**: Suzune Yagi

## Resources Used

+ https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ https://docs.junit.org/current/user-guide/#writing-tests
+ https://jqwik.net/
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Answer to Part 2: Analyzing the Simple String Buffer
The insert method of SimpleStringBuffer.java:
public void insert(char ch) {
        buffer = buffer + ch;
        cursor++;
        sz++;
    }

Analysis on the runtime of the insert method:
1. The relevant input(s) to the method:
    not applicable
2. The critical operation(s).
    buffer = buffer + ch;
    cursor++;
    sz++;
3. A mathematical model of the runtime of insert:
    F(n) = 3
4. Big-O notation:
    The method is O(1)

Whenever insert is called, it makes a new string (buffer + ch) and inserts it into the current buffer, and increment cursor's position and the size, so there are three operations that happen in one call. As Java strings are immutable, we have to make a new string every time insert is called and consequently, size has to be incremented too. This process of making a new string and assigns it to the current buffer makes the operation more expensive and inefficient.