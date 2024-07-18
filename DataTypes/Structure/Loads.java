package DataTypes.Structure;


import java.util.List;
// Definition of the Loads class
public class Loads {
    // Inner class representing a Node in the stack
    public class Node {
        Node next;
        String name;
        // Default constructor for creating a Node with default values
        public Node() {

            this.name = "";
            this.next = null;
        }
        // Constructor for creating a Node with a specified name
        public Node(String name) {

            this.name = name;
            this.next = null;
        }
    }

    private String city;
    private Node top;
    // Constructor for creating a Loads object with a specified city
    public Loads(String city) {
        top = null;
        this.city = city;
    }
    // Method to push a new load onto the top of the stack
    public void push(String name) {
        Node newNode = new Node(name);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    // Method to pop and return the top load from the stack
    public String pop() {
        if (isEmpty()) {
            return "";
        }
        Node poppedValue = top;
        top = top.next;
        return poppedValue.name;
    }
    // Method to return the name of the top load from the stack without removing it
    public String peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is Empty");
        }
        return top.name;
    }
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
