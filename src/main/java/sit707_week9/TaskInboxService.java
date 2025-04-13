package sit707_week9;

import java.util.*;

public class TaskInboxService {
    private static final Map<String, List<Task>> taskDatabase = new HashMap<>();

    static {
        taskDatabase.put("222113273", Arrays.asList(
            new Task("T001", "Design Assignment", "2024-03-01", "Graded"),
            new Task("T002", "Unit Test Report", "2024-04-05", "Submitted")
        ));
    }

    public List<Task> getTasksForStudent(String studentId) {
    	if (studentId == null) {
            return new ArrayList<>();
        }
        return taskDatabase.getOrDefault(studentId, new ArrayList<>());
    }
}