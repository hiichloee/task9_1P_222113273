package sit707_week9;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskInboxServiceTest {
	
    private TaskInboxService service = new TaskInboxService();

    // Existing ID
    @Test
    public void testGetTasksForExistingStudent() {  
        System.out.println("+++ Get tasks for existing student ID +++");
        List<Task> tasks = service.getTasksForStudent("222113273");
        assertEquals(999, tasks.size());
        System.out.println("--- Task 1: " + tasks.get(0).getTitle());
        System.out.println("--- Task 2: " + tasks.get(1).getTitle() + "\n");
    }

    // Non-existing ID
    @Test
    public void testGetTasksForNonExistingStudent() { 
        System.out.println("+++ Get tasks for non-existing student ID +++");
        List<Task> tasks = service.getTasksForStudent("000000000");
        assertTrue(tasks.isEmpty());
        System.out.println("--- No tasks found as expected ---\n");
    }

    // Empty String
    @Test
    public void testGetTasksWithEmptyStudentId() {
        System.out.println("+++ Get tasks with empty student ID +++");
        List<Task> tasks = service.getTasksForStudent("");
        assertTrue(tasks.isEmpty());
        System.out.println("--- Returned empty list ---\n");
    }

    // null value
    @Test
    public void testGetTasksWithNullStudentId() {
        System.out.println("+++ Get tasks with null student ID +++");
        List<Task> tasks = service.getTasksForStudent(null);
        assertTrue(tasks.isEmpty());
        System.out.println("--- Returned empty list ---\n");
    }

    // Data Consistency
    @Test
    public void testTaskDetailsAreConsistent() {
        System.out.println("+++ Check task count vs details consistency +++");
        List<Task> tasks = service.getTasksForStudent("222113273");
        assertEquals(tasks.size(), tasks.stream().map(Task::getTitle).count());
    }
    
    // Batch Query Performance
    @Test
    public void testMultipleDummyStudentIds() {
        System.out.println("+++ Loop through 50 dummy IDs +++");
        for (int i = 0; i < 50; i++) {
            String id = "dummy" + i;
            List<Task> tasks = service.getTasksForStudent(id);
            assertNotNull(tasks); // should be empty, but not null
        }
        System.out.println("--- All dummy lookups returned safe lists ---\n");
    }

}
