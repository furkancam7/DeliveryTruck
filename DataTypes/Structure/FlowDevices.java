package DataTypes.Structure;

import java.util.Objects;

// Definition of the FlowDevices class
public class FlowDevices {
    // Inner class representing a Node in the linked list
    public class Node {
        double priority;
        Node next;
        String city;
        String name;

        boolean used;
        // Default constructor for creating a Node with default values
        public Node() {
            this.priority = 0.0;
            this.city = "";
            this.name = "";
            this.next = null;
            this.used = false;
        }
        // Constructor for creating a Node with specified values for priority, city, and name
        public Node(double priority, String city, String name) {
            this.priority = priority;
            this.city = city;
            this.name = name;
            this.next = null;
            this.used = false;
        }
    }
    // Constructor for creating a FlowDevices object with null head reference
    public FlowDevices() {
        head = null;
    }

    private Node head;
    // Method to add a flow device to the linked list in priority order
    public void addFlowDevice(double priority, String city, String name) {
        Node newNode = new Node(priority, city, name);

        if (head == null || priority > head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    // Method to retrieve the city associated with the highest priority flow device without removing it from the list
    public String peek() {
        return head != null ? head.city : null;
    }
    // Method to retrieve the city associated with the highest priority flow device without removing it from the list
    public String dequeue() {
        if (head == null) {
            return null;
        }

        Node removedNode = head;
        head = head.next;

        return removedNode.city;
    }
    // Method to remove and return the name of the highest priority flow device associated with a specific city from the list
    public String dequeueByCity(String city) {
        Node current = head;
        Node prev = head;

        while (current != null && !current.city.equalsIgnoreCase(city)) {
            prev = current;
            current = current.next;
        }
        Node newNode = current;

        if (current == null) {
            return null;
        }

        if (current == head) {
            head = head.next;
            return current.name;
        } else if (current.next == null) {
            prev.next = null;

            return newNode.name;
        } else {
            prev.next = current.next;

            return newNode.name;
        }

    }
}
