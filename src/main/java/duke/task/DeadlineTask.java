package duke.task;

import java.time.LocalDate;

/**
 * Represents a deadline task.
 */
public class DeadlineTask extends Task {
    protected LocalDate by;

    public DeadlineTask(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        int month = by.getDayOfMonth();
        String formattedDate = by.getMonth().toString().substring(0, 3) + " " + (month < 10 ? "0" + month : month) + " " + by.getYear();
        return "[D]" + super.toString() + " (by: " + formattedDate + ")";
    }
    
    public int compareTo(Task task) {
        if (!(task instanceof DeadlineTask)) {
            return -1;
        }
        DeadlineTask dTask = (DeadlineTask) task;
        return this.by.isBefore(dTask.by)
                ? -1
                : this.by.isAfter(dTask.by)
                ? 1
                : 0;
    }
}
