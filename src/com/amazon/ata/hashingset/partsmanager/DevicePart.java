package com.amazon.ata.hashingset.partsmanager;

import java.util.List;
import java.util.Objects;

public class DevicePart {
    private String manufacturer; // Read-only - no setters - immutable
    private String manufacturersPartNumber; // Read-only - no setters - immutable
    private List<AmazonDevice> devicesUsedIn;

    public DevicePart(String manufacturer, String manufacturersPartNumber, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.devicesUsedIn = devicesUsedIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override
    public String toString() {
        return String.format("Device Part: {manufacturer: %s, manufacturersPartNumber: %s, devicesUsedIn: %s}",
                manufacturer, manufacturersPartNumber, devicesUsedIn);
    }

    // Since there is no equals() nor hashCode() for this class, Java will use the Object class equals() and hashCode()
    // The Object class equals() and hashCode() use the location of the objects, NOT the content of the objects
    // So two objects can never be equal because two objects can never be in the same location
    // And two objects will generate the same hashCode even if their mutable data is different
    // Objects are equal if their content is the same and they should generate different hashCodes if their immutable data is different
    // This is why we use equals() to compare two Strings instead of ==
    // equals() compares content of the String whereas == compares their locations
    // Only data that can't change (immutable) will make two objects equal - use immutable data for equals() and hashCode()

    @Override // Optional - tells compiler to confirm this is a valid override - same method name, same parameters, compatible return types
    public boolean equals(Object o) { // Receives a generic object
        System.out.println("In the .equals() for DevicePart");
        if (this == o) return true;
        if (!(o instanceof DevicePart)) return false;
        DevicePart that = (DevicePart) o; // Instantiate an object of this class from the generic object we are passed
        // Compare the content of the two objects
        return Objects.equals(getManufacturer(), that.getManufacturer()) && Objects.equals(getManufacturersPartNumber(), that.getManufacturersPartNumber());
    }

    @Override
    public int hashCode() {
        System.out.println("In the .hashCode() for DevicePart");
        // Hash codes are not unique. Different data can generate the same hash code.
        // HashSet determines the hashCode for an object and use that hashCode to store it in the set
        // If a hashCode collision occurs - see results of running program button and cuiDevice - HashSet will determine if
        // objects are equal, and if they're not it does not store the second object. If they are, it replaces first object with second object.
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }
}
