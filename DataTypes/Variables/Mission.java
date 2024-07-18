package DataTypes.Variables;

import java.util.List;
// Default constructor

public class Mission {
    String baseStation;
    String middleStation;
    String destinationStation;
    int basePackageToGet;
    int middlePackageToGet;
    List<Integer> toDropAtMiddle;

    public Mission() {

    }
    // Getter method for retrieving the base station
    public String getBaseStation() {
        return baseStation;
    }
    // Setter method for setting the base station
    public void setBaseStation(String baseStation) {
        this.baseStation = baseStation;
    }
    // Getter method for retrieving the middle station
    public String getMiddleStation() {
        return middleStation;
    }
    // Setter method for setting the middle station
    public void setMiddleStation(String middleStation) {
        this.middleStation = middleStation;
    }
    // Getter method for retrieving the destination station
    public String getDestinationStation() {
        return destinationStation;
    }
    // Setter method for setting the destination station
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }
    // Getter method for retrieving the number of packages to get at the middle station
    public int getMiddlePackageToGet() {
        return middlePackageToGet;
    }
    // Getter method for retrieving the number of packages to get at the base station
    public int getBasePackageToGet() {
        return basePackageToGet;
    }
    // Setter method for setting the number of packages to get at the base station

    public void setBasePackageToGet(int basePackageToGet) {
        this.basePackageToGet = basePackageToGet;
    }
    // Setter method for setting the number of packages to get at the middle station

    public void setMiddlePackageToGet(int middlePackageToGet) {
        this.middlePackageToGet = middlePackageToGet;
    }
    // Getter method for retrieving the list of packages to drop at the middle station

    public List<Integer> getToDropAtMiddle() {
        return toDropAtMiddle;
    }
    // Setter method for setting the list of packages to drop at the middle station

    public void setToDropAtMiddle(List<Integer> toDropAtMiddle) {
        this.toDropAtMiddle = toDropAtMiddle;
    }
}
