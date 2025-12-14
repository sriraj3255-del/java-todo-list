import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    String priority;   // High, Medium, Low
    boolean isDone;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.isDone = false;
    }
}

public class ToDoList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        boolean exit = false;

        System.out.println("=== SIMPLE TO-DO LIST WITH PRIORITY ===");

        while (!exit) {

            System.out.println("\n1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Show Pending Tasks Only");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number between 1-5.");
                sc.next();
            }

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 : 
                {   // Add Task
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Task name cannot be empty!");
                        break;
                    }

                    String priority;
                    while (true) {
                        System.out.print("Enter priority (High / Medium / Low): ");
                        priority = sc.nextLine().trim();

                        if (priority.equalsIgnoreCase("High") ||
                            priority.equalsIgnoreCase("Medium") ||
                            priority.equalsIgnoreCase("Low")) {
                            break;
                        }

                        System.out.println("Invalid priority! Please enter High, Medium, or Low.");
                    }

                    tasks.add(new Task(name, priority));
                    System.out.println("Task added successfully!");
                }

                case 2 : 
                        {   // Mark Task as Done
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }

                    System.out.println("\n=== Tasks ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        System.out.println((i + 1) + ". " + t.name +
                                " | Priority: " + t.priority +
                                " | Status: " + (t.isDone ? "Done" : "Not Done"));
                    }

                    System.out.print("Enter task number to mark as done: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input! Enter a valid task number.");
                        sc.next();
                    }

                    int num = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (num >= 1 && num <= tasks.size()) {
                        tasks.get(num - 1).isDone = true;
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                }

                case 3 : 
                        {   // Show All Tasks
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks added yet.");
                        break;
                    }

                    System.out.println("\n=== All Tasks ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        System.out.println((i + 1) + ". " + t.name +
                                " | Priority: " + t.priority +
                                " | Status: " + (t.isDone ? "Done" : "Not Done"));
                    }
                }

                case 4 : 
                        {   // Show Pending Tasks
                    boolean found = false;
                    System.out.println("\n=== Pending Tasks ===");

                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        if (!t.isDone) {
                            found = true;
                            System.out.println((i + 1) + ". " + t.name +
                                    " | Priority: " + t.priority);
                        }
                    }

                    if (!found) {
                        System.out.println("No pending tasks!");
                    }
                }

                case 5 : 
                        {   // Exit
                    exit = true;
                    System.out.println("Goodbye!");
                }

                default : System.out.println("Invalid choice! Please enter a number between 1-5.");
            }
        }

        sc.close();
    }
}
