
/**
 * @author Alexander Loo, Phoenix Ngan, Steven Dao
 * @version 1.0
 * Due Date: April 12th, 2021, 3:59am
 *
 * Purpose: To write a program that demonstrates collections by being able to:
 *                  1) implement a to-do list using priority queues
 *                  2) implement a mini-word processor using stacks
 *                  3) catch and handle any exceptions appropriately
 *                  4) validate the input where needed.
 *
 * Target Output: Show implementation of the concepts listed above through user input and relevant program output.
 */
public class MainTest {

    /**
     * Tests all other classes.
     *
     * @param args command-line arguments for the application of type String array
     */
    public static void main(String[] args) {

        // begin testing

        // test To-Do list
        ToDoList testList = new ToDoList();
        // test Mini Word Processor
        MiniWordProcessor testMiniWP;

        String programOption;
        String inputString;

        do {
            PrintMessage.welcome();
            PrintMessage.showProgramOptions();
            PrintMessage.displayInputSymbol();

            programOption = CheckInput.checkProgramOption();

            if (programOption.equals("t")) {
                // part one tests

                testList.printTest();

            } else if (programOption.equals("m")) {
                // part two tests

                // ask the user for an initial string for the processor
                PrintMessage.getInputString();
                PrintMessage.displayInputSymbol();

                inputString = CheckInput.getInput();

                if (inputString.equals("")) {
                    testMiniWP = new MiniWordProcessor();
                } else {
                    testMiniWP = new MiniWordProcessor(inputString);
                }

                testMiniWP.printTest();
            }

        }  while (!programOption.equals("q"));


        // testing is done
        PrintMessage.goodbye();
    }
}
