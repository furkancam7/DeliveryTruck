package DataTypes.Structure;

import DataTypes.Variables.Mission;

import java.util.List;
// Definition of the Missions class
public class Missions {
    // Inner class representing a Node in the stack
    public class Node {
        Mission mission;
        Node next;
        // Constructor for creating a Node with a specified mission
        public Node(Mission mission) {
            this.mission = mission;
            this.next = null;
        }
        // Default constructor for creating a Node with null mission and next reference

        public Node() {
            this.mission = null;
            this.next = null;
        }
    }

    private Node top;
    // Method to push a new mission onto the stack
    public void push(Mission mission) {
        Node newNode = new Node(mission);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    // Method to pop and return the top mission from the stack
    public Mission pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is Empty");
        }
        Node poppedValue = top;
        top = top.next;
        return poppedValue.mission;
    }
    // Method to return the top mission from the stack without removing it
    public Mission peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is Empty");
        }
        return top.mission;
    }
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }


}
