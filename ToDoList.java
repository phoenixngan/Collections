
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Simulates a to-do list using a priority queue.
 * For our purposes, lower numbers indicate a higher priority.
 */
public class ToDoList {

    private static PriorityQueue<Task> toDoList = null;

    /**
     * Constructs an empty to-do list.
     */
    public ToDoList() {
        toDoList = new PriorityQueue<Task>();
    }

    /**
     * Returns the PriorityQueue to-do list.
     *
     * @return the PriorityQueue to-do list
     */
    public PriorityQueue<Task> getToDoList() {
        return toDoList;
    }

    /**
     * Returns the to-do list as an ordered array.
     * @return the list as an array
     */
    public Object[] getListAsArray() {
        Object[] listAsArray = toDoList.toArray();
        Arrays.sort(listAsArray);

        return listAsArray;
    }

    /**
     * Initiates the to-do list testing and prints the results.
     * Handles any exceptions thrown.
     */
    public void printTest() {
        PrintMessage.welcomeToDoList();
        PrintMessage.showToDoListOptions();

        String input = "";

        do {
            try {
                PrintMessage.displayInputSymbol();

                input = CheckInput.checkToDoListOption();
                parseUserInput(input);

            } catch (NullPointerException error) {
                PrintMessage.noTaskToRemoveError();
            }

        } while (!input.equalsIgnoreCase("quit"));
    }

    /**
     * Parses the user input to perform a task for the to-do list.
     *
     * @param input the user input
     */
    public void parseUserInput(String input) {
        // separate the words in the input to isolate the command
        String[] splitInput = input.toLowerCase().split(" ");

        // the first word should be the command
        switch (splitInput[0]) {
            case "add":
                // omit the command section of the input
                addTask(input.substring(4));
                break;

            case "show":
                showTasks();
                break;

            case "next":
                nextTask();
                break;

            case "quit":
                // remove all elements from the queue
                toDoList.clear();
                break;

            default:
                // if we've reached this point, the first word is an invalid command
                PrintMessage.invalidCommandError(splitInput[0]);
                break;
        }
    }

    /**
     * Retrieves the split input and adds the task to the to-do list.
     * If a task with the same description already exists, the program will display an error and the list of hash codes.
     *
     * @param input the input containing the priority level and the description
     */
    public void addTask(String input) {
        // placeholder Task to point to the new Task casted from each Object in the listAsArray
        Task task;
        // converting the input as a new Task so the descriptions can be compared
        Task inputTask = new Task(input);

        Object[] listAsArray = getListAsArray();
        boolean hasSameDescription = false;

        for (Object obj : listAsArray) {
            task = (Task) obj;

            if (task.equals(inputTask)) {
                hasSameDescription = true;
                PrintMessage.sameDescriptionError();
            }
        }

        if (!hasSameDescription)
            toDoList.add(new Task(input));
        else {
            // tasks are equivalent if they have the same description; print out all objects' hash codes

            StringBuilder hashCodeList = new StringBuilder();

            for (Object obj : listAsArray) {
                task = (Task) obj;

                hashCodeList.append("\n\tTask: ").append(task.getDescription()).append(" | Hash code: ")
                        .append(task.hashCode());
            }

            PrintMessage.displayHashCodeList(hashCodeList.toString());
        }
    }

    /**
     * Displays the tasks in the to-do list.
     */
    public void showTasks() {
        if (toDoList.isEmpty()) {
            PrintMessage.emptyToDoListError();
        } else {
            PrintMessage.displayObject(this);
        }
    }

    /**
     * Removes and prints the most urgent task.
     * Throws a NullPointerException if the list is empty.
     */
    public void nextTask() throws NullPointerException {
        // omit the priority level when printing to the console
        PrintMessage.displayTask(toDoList.poll().getDescription());
    }

    /**
     * Returns a text representation of the to-do list.
     *
     * @return a text representation of the to-do list
     */
    @Override
    public String toString() {
        return "Current list: " + toDoList.toString();
    }
}
