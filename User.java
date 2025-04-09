//Create the User class
public class User {

    //Store user information
    private String name;
    private TaskList list;


    //Construct new user
    public User(String name) {
        this.name = name;
        this.list = new TaskList();
    }


    //Get name when called
    public String getName() {
        return name;
    }


    //Add task to task list
    public void addTask(String description) {
        list.addTask(new Task(description));
    }
    

    //Mark tasks as complete
    public void markComplete(String description) {
        list.markComplete(description);
    }


    //Print list of tasks when called
    public void printAllTasks() {
        System.out.println("Tasks for " + name + ":");
        list.printAllTasks();
    }

}