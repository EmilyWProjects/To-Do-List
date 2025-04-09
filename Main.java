//Imports
import java.util.Scanner;

//Main clas
public class Main {

    //Limit number of users starting from 0 and maximum of 10
    private static User[] users = new User[10]; 
    private static int userCount = 0; 
    private static Scanner scanner = new Scanner(System.in);


    //Initialize menu
    public static void main(String[] args) {


        //Scan input for choice
        while (true) {
            System.out.println("\n==============================");
            System.out.println("   ::: To-Do List Manager :::");
            System.out.println("==============================");
            System.out.println("1. Create a new user");
            System.out.println("2. View User To-Do List");
            System.out.println("3. List all users");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    listUsers();
                    break;
                case 4:
                    System.out.println("\nThank you for using this manager! Goodbye!\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nOops! Please enter a listed option (1-4) and try again!");
            }
        }

    }


    //Create a user
    private static void createUser() {

        if (userCount >= users.length) {
            System.out.println("\nOops! User limit reached!");
            return;
        }

        System.out.print("\nPlease enter your name: ");
        String name = scanner.nextLine();

        //Check if user already exists
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Oops! This name is already taken! Try a different name!");
                return;
            }
        }

        users[userCount] = new User(name);
        userCount++;
        System.out.println("Profile for '" + name + "' has been created!");

    }


    //View user profile
    private static void login() {

        if (userCount == 0) {
            System.out.println("\nOops! No users have been created yet!");
            return;
        }

        System.out.print("\nPlease enter the name of the user: ");
        String name = scanner.nextLine();

        User user = findUser(name);
        if (user == null) {
            System.out.println("Oops! This user could not be found! Please try again!");
            return;
        }

        System.out.println("\nWelcome to your To-Do List Manager, " + user.getName() + "!");
        userMenu(user);

    }


    //List all registered users
    private static void listUsers() {

        if (userCount == 0) {
            System.out.println("\nOops! No users have been created yet!");
            return;
        }

        System.out.println("\n.::. List of Users .::.");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + users[i].getName());
        }

    }


    //Menu for a specific user
    private static void userMenu(User user) {

        while (true) {
            System.out.println("\n==============================");
            System.out.println("   ::: " + user.getName() + "'s Manager :::");
            System.out.println("==============================");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. View all tasks");
            System.out.println("4. Log out");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask(user);
                    break;
                case 2:
                    markComplete(user);
                    break;
                case 3:
                    viewTasks(user);
                    break;
                case 4:
                    System.out.println("\nExiting profile...\n");
                    return;
                default:
                    System.out.println("\nOops! Please enter a listed option (1-4) and try again!");
            }
        }

    }


    //Add a new task to list
    private static void addTask(User user) {

        System.out.print("\nPlease enter a task: ");
        String description = scanner.nextLine();

        user.addTask(description);
        System.out.println("Task added successfully!");

    }


    //Mark tasks as complete
    private static void markComplete(User user) {

        System.out.print("\nPlease enter a task to be marked as completed: ");
        String description = scanner.nextLine();

        user.markComplete(description);
        System.out.println("Task complete!");

    }


    //List tasks for user
    private static void viewTasks(User user) {

        System.out.println("\n.::. To-Do List for " + user.getName() + " .::.");
        user.printAllTasks();

    }


    //Find a given user
    private static User findUser(String name) {

        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;

    }

}
