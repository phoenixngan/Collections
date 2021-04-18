
/**
 * Handles an instance of a task.
 */
public class Task implements Comparable<Task>{

    // includes both the priority level and the description
    private String info;

    /**
     * Constructs an empty task.
     */
    public Task() {
        info = "";
    }

    /**
     * Constructs a task with the given info.
     *
     * @param newInfo the info of the task
     */
    public Task(String newInfo) {
        info = newInfo;
    }

    /**
     * Returns the info of the task.
     *
     * @return the info of the task
     */
    public String getInfo() {
        return info;
    }

    /**
     * Returns the priority level from the info of the task.
     *
     * @return the priority of the task
     */
    public int getPriorityLevel() {
        return Integer.parseInt(String.valueOf(info.charAt(0)));
    }

    /**
     * Returns the description from the info of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return info.substring(2);
    }

    /**
     * Returns the info of the task.
     *
     * @param newInfo the new info of the task
     */
    public void setInfo(String newInfo) {
        info = newInfo;
    }

    /**
     * Compares an object with the called object and returns whether the objects are equivalent.
     * For our purposes, the objects are equivalent if they have the same descriptions.
     *
     * @param obj the object to compare
     * @return true if the object is equivalent, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // check to see if both items are of type Task
        if (!(obj instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) obj;

        // omit the priority levels when comparing
        return getDescription().equalsIgnoreCase(otherTask.getDescription());
    }

    /**
     * Overrides and returns the hash code of the info.
     *
     * @return the hash code of the info
     */
    @Override
    public int hashCode() {
        final int HASH_MULTIPLIER = 31;
        int hashCode = 0;

        for (int i = 0; i < info.length(); ++i) {
            hashCode = HASH_MULTIPLIER * hashCode + info.charAt(i);
        }

        return hashCode;
    }

    /**
     * Implement Comparable / compareTo in order to compare Tasks during insertion.
     *
     * @param otherTask the task to compare to
     * @return -1 if the first task info is first lexicographically,
     *          0 if the task info are equal lexicographically,
     *          and 1 if the second task info is first lexicographically
     */
    @Override
    public int compareTo(Task otherTask) {
        String otherInfo = otherTask.getInfo();
        return CharSequence.compare(info, otherInfo);
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     */
    @Override
    public String toString() {
        return getDescription();
    }
}
