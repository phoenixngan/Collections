
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Simulates a small word processor using stacks.
 */
public class MiniWordProcessor implements MiniWPI {

    /**
     * Constructs a mini word processor with an empty string.
     * The left and right stacks are final and already initialized in the interface.
     */
    public MiniWordProcessor() {}

    /**
     * Constructs a mini word processor with a given string.
     *
     * @param initialString the given string
     */
    public MiniWordProcessor(String initialString) {
        // push the characters of initialString onto the left stack
        char c;

        for (int i = 0; i < initialString.length(); ++i) {
            c = initialString.charAt(i);

            left.push(c);
        }
    }


    /**
     * Returns the left stack.
     *
     * @return the left stack
     */
    public Stack<Character> getLeft() {
        return left;
    }


    /**
     * Returns the right stack.
     *
     * @return the right stack
     */
    public Stack<Character> getRight() {
        return right;
    }


    /**
     * Returns the left stack representation as a string (without array brackets).
     *
     * @return the left stack representation as a string
     */
    public String getLeftStackAsString() {
        StringBuilder leftStack = new StringBuilder();
        int leftSize = left.size();

        // for printing to the console, iterate through the left stack from bottom to top
        for (int i = 0; i < leftSize; ++i) {
            leftStack.append(left.elementAt(i));

            if (i >= 0 && i < leftSize - 1) {
                leftStack.append(", ");
            }
        }

        return leftStack.toString();
    }


    /**
     * Returns the right stack representation as a string (without array brackets).
     *
     * @return the right stack representation as a string
     */
    public String getRightStackAsString() {
        StringBuilder rightStack = new StringBuilder();
        int rightSize = right.size();

        // for printing to the console, iterate through the right stack from top to bottom
        for (int i = rightSize - 1; i >= 0; --i) {
            if (i > 0 && i <= rightSize - 1) {
                rightStack.append(right.elementAt(i)).append(", ");
            } else {
                rightStack.append(right.elementAt(i));
            }
        }

        return rightStack.toString();
    }

    /**
     * Method to print out commands and their results.
     * Handles any exceptions thrown.
     * Since the tests are done using user input instead of hard code, no parameter is needed.
     * */
    @Override
    public void printTest() {
        PrintMessage.welcomeMiniWP();
        PrintMessage.showMiniWPOptions();

        // testing toStringCursor(); show the contents of the initial stacks
        PrintMessage.displayContents("Initial", this.toStringCursor());

        String input = "";

        do {
            try {
                PrintMessage.displayInputSymbol();

                // validate the user input and process the command
                input = CheckInput.checkMiniWPOption();
                processCommand(input);

                // exception handling
            } catch (EmptyStackException error) {
                PrintMessage.searchError();
            }

        } while (!input.equalsIgnoreCase("quit"));
    }

    /**
     * Method that reads in the string that was retrieved from the top of the Queue and executes the appropriate
     * command. It also calls a method to print out the command just executed and the resulting stacks.
     */
    @Override
    public void processCommand(String s) throws EmptyStackException {
        // separate the words in the input to isolate the command
        String[] splitInput = s.toLowerCase().split(" ");

        // the first word should be the command
        switch (splitInput[0]) {

            case "insert":
                // omit the command section of the input
                insertChar(s.charAt(s.length() - 1));
                break;

            case "backspace":
                backspace();
                break;

            case "delete":
                delete();
                break;

            case "move":
                // move the cursor depending on the direction
                if (splitInput[1].equals("left")) {
                    moveLeft();
                } else if (splitInput[1].equals("right")) {
                    moveRight();
                } else if (splitInput[2].equals("start")) {
                    moveToStart();
                } else {
                    moveToEnd();
                }
                break;

            case "search":
                // omit the command section of the input
                if (!search(s.charAt(s.length() - 1))) {
                    // let the user know the character could not be found
                    PrintMessage.characterNotFoundError(s.charAt(s.length() - 1));
                }
                break;

            case "quit":
                // remove all elements from both stacks
                left.clear();
                right.clear();
                break;

            default:
                // if we've reached this point, the first word is an invalid command
                PrintMessage.invalidCommandError(splitInput[0]);
                break;
        }

        // testing toStringCursor(); show the command and contents of the stacks
        PrintMessage.displayContents(s, this.toStringCursor());
    }

    /**
     * Insert c into the string at the cursor.
     */
    @Override
    public void insertChar(char c) {
        // insert before the cursor
        left.push(c);
    }

    /**
     * Delete the character before the cursor.
     * If there is none, do nothing.
     */
    @Override
    public void backspace() {
        if (!left.isEmpty()) {
            left.pop();
        }
    }

    /**
     * Delete the character after the cursor.
     * If there is none, do nothing.
     * */
    @Override
    public void delete() {
        if (!right.isEmpty()) {
            right.pop();
        }
    }

    /**
     * Move the cursor left 1 character.
     * If we're already at the start of the string, do nothing.
     */
    @Override
    public void moveLeft() {
        if (!isAtStart()) {
            // pop from the left and push onto the right stack
            right.push(left.pop());
        }
    }

    /**
     * Move the cursor right 1 character.
     * If we're already at the end of the string, do nothing.
     */
    @Override
    public void moveRight() {
        if (!isAtEnd()) {
            // pop from the right and push onto the left stack
            left.push(right.pop());
        }
    }

    /**
     * Is the cursor at the start of the text?
     */
    @Override
    public boolean isAtStart(){
       return left.isEmpty();
    }

    /**
     * Is the cursor at the end of the text?
     */
    @Override
    public boolean isAtEnd() {
       return right.isEmpty();
    }

    /**
     * Move the cursor to the start of the text.
     */
    @Override
    public void moveToStart() {
        // move left until you reach the start of the string
         while (!isAtStart()) {
             moveLeft();
         }
    }

    /**
     * Move the cursor to the end of the text.
     */
    @Override
    public void moveToEnd() {
        // move right until you reach the end of the string
        while (!isAtEnd()) {
            moveRight();
        }
    }

    /**
     * Search forward for the next occurrence of c that starts at the cursor or later.
     * If found, leave the cursor immediately after that occurrence and return true.
     * Else, leave the cursor at the end of the text and return false.
     * */
    @Override
    public boolean search(char c) throws EmptyStackException {
        // let the user know the empty stack has nothing to search
        if (right.isEmpty()) {
           throw new EmptyStackException();
        }

        // check if the specified character exists in the right stack
        if (right.contains(c)) {
            // store the found character's index
            int charIndex = right.search(c);

            // move right until the cursor passes the found character
            for (int i = 0; i < charIndex; ++i) {
                moveRight();
            }

            return true;
        }

        // if we've reached this point, the right stack does not contain the specified character
        moveToEnd();
        return false;
    }

    /**
     * Convert to string. The cursor position is ignored.
     * @see #toStringCursor()
     *
     * @return the description as a string
     */
    @Override
    public String toString() {
        String description = "[" + getLeftStackAsString();

        if (right.isEmpty()) {
            description += "]";
        } else if (left.isEmpty()) {
            description += getRightStackAsString() + "]";
        } else {
            description += ", " + getRightStackAsString() + "]";
        }

        return description;
    }

    /**
     * Like toString, but the special character `|` is included to mark the cursor position.
     *
     * @return the description as a string
     */
    @Override
    public String toStringCursor() {
        return "[" + getLeftStackAsString() + "]  |  [" + getRightStackAsString() + "]";
    }
}
