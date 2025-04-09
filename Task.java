//Create Task class
public class Task {
    
    //Store task information
    private String description;
    private boolean isCompleted;


    //Construct new task
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; 
    }


    //Get task description
    public String getDescription() {
        return description;
    }


    //Check if task is completed
    public boolean isCompleted() {
        return isCompleted;
    }


    //Marks complete if true
    public void markComplete() {
        this.isCompleted = true;
    }
    

    //Reads boolean task status, complete if true and pending if false
    @Override
    public String toString() {
        return description + " (" + (isCompleted ? "Complete" : "Pending") + ")";
    }

}