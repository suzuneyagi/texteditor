# CSC 207: Text Editor

**Author**: Suzune Yagi

## Resources Used

+ https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ https://docs.junit.org/current/user-guide/#writing-tests
+ https://jqwik.net/
+ https://github.com/mojohaus/exec-maven-plugin/issues/144
+ Visual Studio Code 
+ Oracle, OpenJDK compiler
+ ...

## Changelog
commit 1762422fd96da99eca0fb2435252813f5cd3e130 (HEAD -> main)
Author: suzuneyagi <yagiryouyasushi@MacBookAir.grinnell.edu>
Date:   Mon Oct 6 20:11:55 2025 -0500

    Completed README

commit 76dfb4d20b7470f567440c6a28276605381c1ee4 (HEAD -> main, origin/main, origin/HEAD)
Author: suzuneyagi <yagiryouyasushi@MacBookAir.grinnell.edu>
Date:   Mon Oct 6 19:39:44 2025 -0500

    Added Javadoc comments

commit ed5512cc2b88795f55d4b11eb86951215b7f8fad
Author: suzuneyagi <yagiryouyasushi@MacBookAir.grinnell.edu>
Date:   Mon Oct 6 19:31:53 2025 -0500

    Implemented file input/output

commit ba33fceabd1001aac3245af1a078e0d126ff984a
Author: suzuneyagi <yagiryouyasushi@MacBookAir.grinnell.edu>
Date:   Mon Oct 6 19:03:57 2025 -0500

    Modified logical errors and added Javadoc to GapBuffer.java

commit fa6e8020cbb878129a0f8ad6f9f0fc90b593cf35
Author: suzuneyagi <yagiryouyasushi@MacBookAir.grinnell.edu>
Date:   Sat Oct 4 23:12:20 2025 -0500

    Implemented SimpleStringBuffer and GapBuffer. Started TUI.


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