package taskmanager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) throws Exception {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Task.class, new TaskSerialization());
        Gson gson = builder.create();
        String command;
        String taskName, taskDescription, taskDate;
        List<Task> taskList = new ArrayList<Task>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command:");
        command = sc.nextLine();
        while (!"exit".equals(command)) {
            if (command.equals("new task")) {
                System.out.println("Name:");
                taskName = sc.nextLine();
                System.out.println("Description:");
                taskDescription = sc.nextLine();
                System.out.println("Due date (hh:mm:ss dd/MM/yyyy):");
                taskDate = sc.nextLine();
                taskList.add(new Task(taskName, taskDescription, taskDate));
            }
            if (command.equals("view tasks")) {
                int size = taskList.size();
                for(int i = 0; i < size; i++) {
                    taskList.get(i).getTaskName();
                    taskList.get(i).getTaskDescription();
                    taskList.get(i).getTaskDate();
                }
            }
            if (command.equals("delete task")) {
                System.out.println("Enter task number, what do you want to delete:");
                int i = sc.nextInt();
                if (taskList.size() >= i)
                    taskList.remove(sc);
                else 
                    System.out.println("ERROR");
            }
            if (command.equals("help")) {
                System.out.println("You can use commands:");
                System.out.println("  - new task");
                System.out.println("  - view tasks");
                System.out.println("  - delete task");
            }
            System.out.println("Enter command:");
            command = sc.nextLine();
        }
        // serial
        String json = gson.toJson(taskList);
        File dir = new File("C://NC");
        boolean created = dir.mkdir();
        File file = new File("C://NC//TaskManager.json");
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(json);
        System.out.println(json);
        // deserial
        Type listtype = new TypeToken<ArrayList<Task>>(){}.getType();
        List<Task> taskList2 = new Gson().fromJson(json, listtype);
          int size = taskList2.size();
                for(int i = 0; i < size; i++) {
                    taskList2.get(i).getTaskName();
                    taskList2.get(i).getTaskDescription();
                    taskList2.get(i).getTaskDate();
                }
    }
}
