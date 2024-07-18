package FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// Definition of the Output class
public class Output {
    // Default constructor
    public Output() {

    }
    // Method to output the provided text to a file
    public static void outputResult(String text) {
        String fileName = "input\\result.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);// Write the provided text to the file
            bufferedWriter.newLine();// Move to the next line

            bufferedWriter.close(); // Close the BufferedWriter


        } catch (IOException e) {
            // Handle any IOException that may occur during file writing
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

}
