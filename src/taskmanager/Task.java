package taskmanager;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task {
    String taskName;
    String taskDescription;
    Date taskDate = new Date(); // пересмотреть
    public Task(String taskName, String taskDescription, String taskDateString) throws Exception  {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("hh:mm:ss dd/MM/yyyy");
        Date taskDate = format.parse(taskDateString);
        this.taskDate = taskDate;
    }
    public void getTaskName() {
        System.out.println("Name: " + taskName);
    }
    public void getTaskDescription() {
       System.out.println("Description: " + taskDescription);
    }
    public void getTaskDate() {
        System.out.println("Date: " + taskDate.toString());
    }
}
