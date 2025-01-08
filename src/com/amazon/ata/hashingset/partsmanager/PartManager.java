package com.amazon.ata.hashingset.partsmanager;

import java.util.HashSet;
import java.util.Set;

public class PartManager {
    // HashSet is a Collection class to hold unique elements - no duplicates (different from ArrayList which can have duplicates)
    private Set<DevicePart> deviceParts = new HashSet<>();

    public void addDevicePart(DevicePart devicePart) {
        boolean isAdded = deviceParts.add(devicePart);
    }

    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
