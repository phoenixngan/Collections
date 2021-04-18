
import java.util.Stack;

/**
 * Interface for the Mini Word Processor.
 * All variables declared inside an interface are implicitly public, static, and final.
 */
public interface MiniWPI {

    /**
     * Stack of Characters to the left of the cursor; the ones near the top of the stack are closest to the cursor.
     */
    Stack<Character> left = new Stack<Character>();

    /**
     * Stack of Characters to the right of the cursor; the ones near the top of the stack are closest to the cursor.
     */
    Stack<Character> right = new Stack<Character>();


    /**
     * Method to print out commands and their results.
     * Handles any exceptions thrown.
     * Since the tests are done using user input instead of hard code, no parameter is needed.
     * */
    void printTest();


    /**
     * Method that reads in the string that was retrieved from the top of the Queue and executes the appropriate
     * command. It also calls a method to print out the command just executed and the resulting stacks.
     */
    void processCommand(String s);


    /**
     * Insert c into the string at the cursor.
     */
    void insertChar(char c);


    /**
     * Delete the character before the cursor.
     * If there is none, do nothing.
     */
    void backspace();


    /**
     * Delete the character after the cursor.
     * If there is none, do nothing.
     * */
    void delete();


    /**
     * Move the cursor left 1 character.
     * If we're already at the start of the string, do nothing.
     */
    void moveLeft();


    /**
     * Move the cursor right 1 character.
     * If we're already at the end of the string, do nothing.
     */
    void moveRight();


    /**
     * Is the cursor at the start of the text?
     */
    boolean isAtStart();


    /**
     * Is the cursor at the end of the text?
     */
    boolean isAtEnd();


    /**
     * Move the cursor to the start of the text.
     */
    void moveToStart();


    /**
     * Move the cursor to the end of the text.
     */
    void moveToEnd();


    /**
     * Search forward for the next occurrence of c that starts at the cursor or later.
     * If found, leave the cursor immediately after that occurrence and return true.
     * Else, leave the cursor at the end of the text and return false.
     * */
    boolean search(char c);


    /**
     * Convert to string. The cursor position is ignored.
     * @see #toStringCursor()
     */
    String toString();


    /**
     * Like toString, but the special character `|` is included to mark the cursor position.
     */
    String toStringCursor();

}
