//Create TaskList class
public class TaskList {

    //Define linked list head
    private Node head;


    //Create linked list and set null to end list
    private class Node {

        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }

    }


    //Add task to list as node
    public void addTask(Task task) {

        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }
    

    //Go through each entry and find match to mark complete
    public void markComplete(String description) {

        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equalsIgnoreCase(description)) {
                current.task.markComplete();
                break;
            }
            current = current.next;
        }

    }

    
    //Print all nodes
    public void printAllTasks() {

        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }

    }
    
}