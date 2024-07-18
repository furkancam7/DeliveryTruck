package DataTypes.Structure;

import java.util.ArrayList;
import java.util.List;
// Definition of the Destinations class
public class Destinations {
    // Inner class representing a Node in the linked list
    public class Node {
        String city;
        List<String> flowDevices;
        List<String> loads;


        Node next;
        Node prev;
        // Constructor to create a Node with a specified city name
        public Node(String city) {
            this.city = city;
            this.next = null;
            this.prev = null;

            flowDevices = new ArrayList<>();
            loads = new ArrayList<>();
        }
        // Default constructor
        public Node() {
            this.city = "";
            this.next = null;
            this.prev = null;
        // Initialize lists for flow devices and loads
            flowDevices = new ArrayList<>();
            loads = new ArrayList<>();
        }
    }
    // Reference to the head and tail nodes of the linked list
    private Node head;
    private Node tail;

    int size;
    // Constructor to initialize an empty Destinations object
    public Destinations() {
        head = null;
        tail = null;
    }
    // Method to add a new city to the linked list
    public void add(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    // Method to get the city name at a specified index in the linked list
    public String get(int index) {
        Node walk = head;

        for (int i = 0; i < index; i++) {
            walk = walk.next;
        }

        return walk.city;
    }
    // Method to get and remove the city at a specified index in the linked list
    public String getAndRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current == head) {
            return removeFirst();
        } else if (current == tail) {
            return removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return current.city;
        }
    }
    // Private helper method to remove the first node from the linked list
    private String removeFirst() {
        String removedData = head.city;
        if (head == tail) { // Only one element in the list
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedData;
    }

    // Private helper method to remove the last node from the linked list
    private String removeLast() {
        String removedData = tail.city;
        if (head == tail) { // Only one element in the list
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedData;
    }
    // Method to add a flow device to a specified city
    public void addFlowDevice(String city, String flowDevice) {
        Node curr = head;

        if (city == null || flowDevice == null) {
            return;
        }

        while (!curr.city.equalsIgnoreCase(city)) {
            curr = curr.next;
        }
        curr.flowDevices.add(flowDevice);
    }
    // Method to add a package load to a specified city
    public void addPackage(String city, String load) {
        Node curr = head;

        while (!curr.city.equalsIgnoreCase(city)) {
            curr = curr.next;
        }
        curr.loads.add(load);
    }
    // Method to remove a package load from a specified city
    public void popByCity(String city) {
        Node curr = head;

        while (curr != null && !curr.city.equalsIgnoreCase(city)) {
            curr = curr.next;
        }
        if (curr.loads.isEmpty() || curr == null) {
            return;
        }

        curr.loads.removeFirst();
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to print the contents of the linked list
    public void printList() {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            System.out.println(curr.city);
            curr = curr.next;
        }
    }

    // Override toString method to represent the contents of the Destinations object as a string
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        Node curr = head;

        while (curr != null) {
            output.append(curr.city).append("\n").append("Loads:").append("\n");

            for (int i = 0; i < curr.loads.size(); i++) {
                output.append(curr.loads.get(i)).append("\n");
            }
            output.append("Flow Devices:").append("\n");
            for (int i = 0; i < curr.flowDevices.size(); i++) {
                output.append(curr.flowDevices.get(i)).append("\n");
            }

            output.append("-------------").append("\n");

            curr = curr.next;
        }


        return output.toString();
    }
}
