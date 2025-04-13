package sit707_week9;

import java.util.List;

public class Task {
    private String taskId;
    private String title;
    private String submissionDate;
    private String status;

    public Task(String taskId, String title, String submissionDate, String status) {
        this.taskId = taskId;
        this.title = title;
        this.submissionDate = submissionDate;
        this.status = status;
    }

    // Getters
    public String getTaskId() { return taskId; }
    public String getTitle() { return title; }
    public String getSubmissionDate() { return submissionDate; }
    public String getStatus() { return status; }
}
