
/**
 * Handles all instances of using PrintStream for output to the console.
 */
public class PrintMessage {


    // To-Do List Output


    /**
     * Displays a welcome message for the to-do list.
     */
    public static void welcomeToDoList() {
        System.out.println("----------------------------------------\n" +
                            "    To-Do List using Priority Queues\n" +
                            "----------------------------------------");
    }

    /**
     * Displays the options for handling the to-do list.
     */
    public static void showToDoListOptions() {
        System.out.println("Please choose an option:\n" +
                            "\tAdd priority description (add a new task)\n" +
                            "\tShow (display the tasks)\n" +
                            "\tNext (remove and print most urgent task)\n" +
                            "\tQuit (exit this program)");
    }

    /**
     * Displays the specified task.
     *
     * @param task the task to display
     */
    public static void displayTask(String task) {
        System.out.println("--- \"" + task + "\" has been removed.");
    }

    /**
     * Displays the list of objects’ hash codes.
     *
     * @param hashCodeList the string block of the list of hash codes
     */
    public static void displayHashCodeList(String hashCodeList) {
        System.out.println("To-Do List: [" +
                hashCodeList +
                "\n]");
    }

    /**
     * Displays an error message indicating that the command needs a valid priority level and description.
     *
     * @param input the invalid input
     */
    public static void noPriorityDescriptionError(String input) {
        System.out.print("The command \"" + input + "\" needs a priority level and description; please try again: ");
    }

    /**
     * Displays an error message indicating that the command does not contain a valid description.
     *
     * @param input the invalid input
     */
    public static void noDescriptionError(String input) {
        System.out.print("The command \"" + input + "\" needs a description; please try again: ");
    }

    /**
     * Displays an error message indicating that the input is not a valid priority level.
     */
    public static void invalidPriorityError() {
        System.out.print("The priority must be an integer between 1 and 9; please try again: ");
    }

    /**
     * Displays an error message indicating that a task already has the same description as the input.
     */
    public static void sameDescriptionError() {
        System.out.println("A task with the same description already exists; the input cannot be added.");
    }

    /**
     * Displays an error message indicating that the to-do list is empty.
     */
    public static void emptyToDoListError() {
        System.out.println("The list is empty.");
    }

    /**
     * Displays an error message indicating that there are no tasks to remove within the list.
     */
    public static void noTaskToRemoveError() {
        System.out.println("There are no tasks in the list.");
    }


    // Mini Word Processor Output


    /**
     * Displays a welcome message for the mini word processor.
     */
    public static void welcomeMiniWP() {
        System.out.println("----------------------------------------\n" +
                            "    Mini Word Processor using Stacks\n" +
                            "----------------------------------------");
    }

    /**
     * Prompts the user for an initial string for the mini word processor.
     */
    public static void getInputString() {
        System.out.println("Enter an initial string: ");
    }

    /**
     * Displays the options for handling the mini word processor.
     */
    public static void showMiniWPOptions() {
        System.out.println("Please choose an option:\n" +
                            "\tInsert (add a new character before the cursor)\n" +
                            "\tBackspace (delete the character to the left of the cursor)\n" +
                            "\tDelete (delete the character to the right of the cursor)\n" +
                            "\tMove (move the cursor `left`, `right`, `to start`, or `to end`)\n" +
                            "\tSearch (move the cursor to the right of this next character)\n" +
                            "\tQuit (exit this program)\n");
    }

    /**
     * Displays the command and contents of the stacks.
     *
     * @param command the command made
     * @param stackToString the string representation of the stacks
     */
    public static void displayContents(String command, String stackToString) {
        System.out.println(String.format("%-20s", "--- " + command + ": " ) + stackToString);
    }

    /**
     * Displays an error message indicating that the command needs a character.
     *
     * @param input the invalid input
     */
    public static void noCharacterError(String input) {
        System.out.print("The command \"" + input + "\" needs a character; please try again: ");
    }

    /**
     * Displays an error message indicating that the command needs a direction.
     *
     * @param input the invalid input
     */
    public static void noDirectionError(String input) {
        System.out.print("The command \"" + input + "\" needs a direction; please try again: ");
    }

    /**
     * Displays an error message indicating that the command does not contain a single character.
     *
     * @param input the invalid input
     */
    public static void invalidCharacterError(String input) {
        System.out.print("The command \"" + input + "\" does not contain a single character; please try again: ");
    }

    /**
     * Displays an error message indicating that the command contains an invalid direction.
     *
     * @param input the invalid input
     */
    public static void invalidDirectionError(String input) {
        System.out.print("The command \"" + input + "\" contains an invalid direction; please try again: ");
    }

    /**
     * Displays an error message indicating that the specified character could not be found.
     *
     * @param c the character that could not be found
     */
    public static void characterNotFoundError(char c) {
        System.out.println("The character \"" + c + "\" could not be found; please try again.");
    }

    /**
     * Displays an error message indicating that there is nothing to search.
     */
    public static void searchError() {
        System.out.println("There is nothing to search; please try again.");
    }


    // General-use output


    /**
     * Displays a welcome message.
     */
    public static void welcome() {
        System.out.println("--------------------------------------------\n" +
                            "    Welcome to the world of Collections.\n" +
                            "--------------------------------------------");
    }

    /**
     * Displays the options for the programs to run.
     */
    public static void showProgramOptions() {
        System.out.println("Select a program to run:\n" +
                            "\tT)o-do List\n" +
                            "\tM)ini Word Processor\n" +
                            "\tQ)uit");
    }

    /**
     * Displays an error message indicating that the input is not a valid command.
     *
     * @param input the invalid input
     */
    public static void invalidCommandError(String input) {
        System.out.print("The input \"" + input + "\" is not a valid command; please try again: ");
    }

    /**
     * Displays the symbol " >> " to the user, signaling to them to provide input.
     */
    public static void displayInputSymbol() {
        System.out.print(" >> ");
    }

    /**
     * Displays the object using its toString() method.
     *
     * @param obj the object to display
     */
    public static void displayObject(Object obj) {
        System.out.println(obj);
    }


    /**
     * Displays a goodbye message.
     */
    public static void goodbye() {
        System.out.println("\n------------------------------------\n" +
                            "    Main program has terminated.\n" +
                            "------------------------------------");
    }
}
