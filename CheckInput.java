
import java.util.Scanner;

/**
 * Handles all instances of user input and input validation.
 */
public class CheckInput {


    // To-Do List input checks


    /**
     * Checks if the input is one of the valid options for the to-do list.
     *
     * @return the valid input
     */
    public static String checkToDoListOption() {
        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            input = in.nextLine();
            String[] splitInput = input.split(" ");

            if (splitInput[0].equalsIgnoreCase("add")) {

                if (splitInput.length < 2) {
                    // the input is missing the priority level and description
                    PrintMessage.noPriorityDescriptionError(input);

                } else if (!isInValidIntRange(splitInput[1], 1, 9)) {
                    // the input does not have a valid priority level within the range
                    PrintMessage.invalidPriorityError();

                } else if (splitInput.length < 3) {
                    // the input is missing the description
                    PrintMessage.noDescriptionError(input);

                } else {
                    return input;
                }

            } else if (input.equalsIgnoreCase("show") ||
                    input.equalsIgnoreCase("next") ||
                    input.equalsIgnoreCase("quit")) {
                return input;

            } else {
                PrintMessage.invalidCommandError(input);
            }
        }
    }

    /**
     * Checks if the input value is an integer within the specified range.
     * Modified from CheckInput.java.
     *
     * @param input the user input
     * @return whether the input was a valid integer.
     */
    public static boolean isInValidIntRange(String input, int low, int high) {
        Scanner in = new Scanner(input);

        if (in.hasNextInt()) {
            int inputAsInt = Integer.parseInt(input);
            return inputAsInt <= high && inputAsInt >= low;
        }
        return false;
    }


    // Mini Word Processor input checks


    /**
     * Checks if the input is one of the valid options for the mini word processor.
     *
     * @return the valid input
     */
    public static String checkMiniWPOption() {
        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            input = in.nextLine();
            String[] splitInput = input.split(" ");

            // the first word should be the command
            // `insert` and `search` require the same input validation
            if (splitInput[0].equalsIgnoreCase("insert") ||
                    splitInput[0].equalsIgnoreCase("search")) {

                if (splitInput.length < 2) {
                    PrintMessage.noCharacterError(input);

                } else if (splitInput.length > 2 ||
                        splitInput[1].length() > 1)
                    PrintMessage.invalidCharacterError(input);

                else
                    return input;

                // `backspace` and `remove` require the same input validation
            } else if (splitInput.length == 1 &&
                    (splitInput[0].equalsIgnoreCase("backspace") ||
                    splitInput[0].equalsIgnoreCase("delete"))) {

                return input;


            } else if (splitInput[0].equalsIgnoreCase("move")) {

                if (splitInput.length < 2) {
                    PrintMessage.noDirectionError(input);

                } else if (splitInput.length == 2 &&
                        (splitInput[1].equalsIgnoreCase("left") ||
                                splitInput[1].equalsIgnoreCase("right"))) {
                    return input;

                } else if (splitInput.length == 3 &&
                        splitInput[1].equalsIgnoreCase("to") &&
                        (splitInput[2].equalsIgnoreCase("start") ||
                                splitInput[2].equalsIgnoreCase("end"))) {

                    return input;

                } else {
                    PrintMessage.invalidDirectionError(input);
                }

            } else if (splitInput[0].equalsIgnoreCase("quit")) {

                return input;

                // if we've reached this far, the input is not a valid command
            } else {
                PrintMessage.invalidCommandError(input);
            }
        }
    }


    // Miscellaneous input checks

    /**
     * Checks if the input is one of the valid options for programs.
     *
     * @return the valid input as all lowercase lowercase characters
     */
    public static String checkProgramOption() {
        Scanner in = new Scanner(System.in);
        String input;

        while (true) {
            input = in.nextLine();

            if (input.equalsIgnoreCase("t") ||
                    input.equalsIgnoreCase("m") ||
                    input.equalsIgnoreCase("q")) {
                return input.toLowerCase();
            } else {
                PrintMessage.invalidCommandError(input);
            }
        }
    }

    /**
     * Gets and returns the user's input.
     */
    public static String getInput() {
        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }
}
