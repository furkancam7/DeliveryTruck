package Manager;

import DataTypes.Structure.Destinations;
import DataTypes.Structure.FlowDevices;
import DataTypes.Structure.Loads;
import DataTypes.Structure.Missions;
import DataTypes.Variables.Mission;
import FileIO.Output;
import FileIO.ParseData;

import java.util.HashMap;
import java.util.Map;

// Definition of the LoadDeliveryOperation class
public class LoadDeliveryOperation {
    // Instance variables declaration
    private FlowDevices flowDevices;
    private Destinations destinations;
    private Missions missions;
    private Map<String, Loads> loads;
    // Constructor for LoadDeliveryOperation class
    public LoadDeliveryOperation() {
        readInput();
    }
    // Method to read input data from files and initialize objects
    private void readInput() {
        // Initialize objects
        flowDevices = new FlowDevices();
        destinations = new Destinations();
        missions = new Missions();
        loads = new HashMap<>();
        // Parse flow devices data from file
        ParseData.parseFlowDevice("input\\flowdevices.txt", flowDevices);
        // Parse destinations data from file
        ParseData.parseDestinations("input\\destinations.txt", destinations);
        // Parse missions data from file
        ParseData.parseMissions("input\\missions.txt", missions);
        // Parse loads data from file
        ParseData.parseLoads("input\\loads.txt", loads);

    }
    // Method to operate the load delivery process
    public void operate() {
        // Process each mission until missions are empty
        while (!missions.isEmpty()) {
            // Get the current mission
            Mission currentMission = missions.pop();
            // Add flow device for the base station
            destinations.addFlowDevice(currentMission.getBaseStation(), flowDevices.dequeueByCity(currentMission.getBaseStation()));
            // Handle packages for the base station
            for (int i = 0; i < currentMission.getBasePackageToGet(); i++) {
                String load = loads.get(currentMission.getBaseStation()).pop();
                if (load.isEmpty()) {
                    continue;
                }
                destinations.addPackage(currentMission.getBaseStation(), load);
            }
            // Add flow device for the middle station
            destinations.addFlowDevice(currentMission.getMiddleStation(), flowDevices.dequeueByCity(currentMission.getMiddleStation()));
            // Handle packages for the middle station
            for (int i = 0; i < currentMission.getMiddlePackageToGet(); i++) {
                String load = loads.get(currentMission.getMiddleStation()).pop();

                if (load.isEmpty()) {
                    continue;
                }

                destinations.addPackage(currentMission.getMiddleStation(), load);
            }
            // Drop packages at the middle station
            for (int i = 0; i < currentMission.getToDropAtMiddle().size(); i++) {
                for (int j = 0; j < currentMission.getToDropAtMiddle().get(i); j++) {
                    destinations.popByCity(currentMission.getMiddleStation());
                }
            }

        }
        // Output the final state of destinations
        Output.outputResult(destinations.toString());
    }

}
