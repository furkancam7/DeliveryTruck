import Manager.LoadDeliveryOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tester1 {
    public static void main(String[] args) {
        testLoadDeliveryOperation();
    }

    public static void testLoadDeliveryOperation() {
        System.out.println("Testing LoadDeliveryOperation:");

        // Test Case 1: Test with empty input files
        // Create empty input files
        createEmptyFile("input\\flowdevices.txt");
        createEmptyFile("input\\destinations.txt");
        createEmptyFile("input\\missions.txt");
        createEmptyFile("input\\loads.txt");

        // Create instance of LoadDeliveryOperation
        LoadDeliveryOperation loadDeliveryOperation1 = new LoadDeliveryOperation();

        // Call operate method to perform load delivery operations
        loadDeliveryOperation1.operate();

        // Expected: No exceptions should be thrown and the program should gracefully handle empty input files

        // Test Case 2: Test with invalid input files
        // Create invalid input files
        createInvalidFile("input\\flowdevices.txt", "Invalid content");
        createInvalidFile("input\\destinations.txt", "Invalid content");
        createInvalidFile("input\\missions.txt", "Invalid content");
        createInvalidFile("input\\loads.txt", "Invalid content");

        // Create instance of LoadDeliveryOperation
        LoadDeliveryOperation loadDeliveryOperation2 = new LoadDeliveryOperation();

        // Call operate method to perform load delivery operations
        loadDeliveryOperation2.operate();

        // Expected: The program should gracefully handle invalid input format and continue execution
        // Test Case 3: Test with missing input files
        // Remove input files
        removeFile("input\\flowdevices.txt");
        removeFile("input\\destinations.txt");
        removeFile("input\\missions.txt");
        removeFile("input\\loads.txt");

        // Create instance of LoadDeliveryOperation
        LoadDeliveryOperation loadDeliveryOperation3 = new LoadDeliveryOperation();

        // Call operate method to perform load delivery operations
        loadDeliveryOperation3.operate();

        // Expected: The program should handle missing input files gracefully and continue execution

        System.out.println("LoadDeliveryOperation tests completed.");
    }

    public static void removeFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }



    public static void createEmptyFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createInvalidFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
