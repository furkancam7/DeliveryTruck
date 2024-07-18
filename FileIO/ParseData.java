package FileIO;


import DataTypes.Structure.Destinations;
import DataTypes.Structure.FlowDevices;
import DataTypes.Structure.Loads;
import DataTypes.Structure.Missions;
import DataTypes.Variables.Mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
// Definition of the ParseData class

public class ParseData {
    // Method to parse flow device data from a file and add them to the provided FlowDevices object

    public static void parseFlowDevice(String filename, FlowDevices flowDevices) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read each line from the file

            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    // Handle IOException
                    throw new RuntimeException(e);
                }
                // Split the line into parts
                String[] parts = line.split(" ");
                // Check if the line has the correct format
                if (parts.length == 3) {
                    // Parse priority as a double
                    double priority = Double.parseDouble(parts[2]);
                    // Add flow device with priority, city, and name
                    flowDevices.addFlowDevice(priority, parts[1], parts[0]);
                } else {
                    // Print error message for invalid input format
                    System.out.println("Invalid input format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to parse destination data from a file and add them to the provided Destinations object
    public static void parseDestinations(String filename, Destinations destinations) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Add destination to the Destinations object
                destinations.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Method to parse mission data from a file and add them to the provided Missions object
    public static void parseMissions(String filename, Missions missions) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Read each line from the file

            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split("-");
                // Check if the line has the correct format
                if (parts.length >= 5) {
                    // Create a new Mission object
                    Mission mission = new Mission();
                    // Set mission details
                    mission.setBaseStation(parts[0]);
                    mission.setMiddleStation(parts[1]);
                    mission.setDestinationStation(parts[2]);
                    mission.setBasePackageToGet(Integer.parseInt(parts[3]));
                    mission.setMiddlePackageToGet(Integer.parseInt(parts[4].split(",")[0]));
                    // Parse and set drop packages at middle station
                    mission.setToDropAtMiddle(parseDropPackages(Arrays.copyOfRange(parts, 4, parts.length)));
                    // Push the mission to the Missions object
                    missions.push(mission);
                } else {
                    System.out.println("Invalid input format: asdasd" + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Private helper method to parse drop package data from a string array and returns a list of integers
    private static List<Integer> parseDropPackages(String[] dropPackagesStr) {
        List<Integer> dropPackages = new ArrayList<>();
        for (int i = 1; i < dropPackagesStr.length; i++) {
            String[] parts = dropPackagesStr[i].split(",");
            for (String part : parts) {
                dropPackages.add(Integer.parseInt(part));
            }
        }
        return dropPackages;
    }
    // Method to parse load data from a file and add them to the provided Loads object mapped by destination
    public static void parseLoads(String fileName, Map<String, Loads> loadsMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split(" ");
                // Check if the line has the correct format
                if (parts.length == 2) {
                    String loadId = parts[0];
                    String destination = parts[1];
                    // Check if destination already exists in the loadsMap
                    if (loadsMap.containsKey(destination)) {
                        // Add load to existing Loads object
                        loadsMap.get(destination).push(loadId);
                    } else {
                        // Create a new Loads object and add load to it
                        Loads newLoad = new Loads(destination);
                        loadsMap.put(destination, newLoad);
                        newLoad.push(loadId);
                    }

                } else {
                    // Print error message for invalid input format
                    System.out.println("Invalid input format: " + line);
                }
            }
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

    }
}
