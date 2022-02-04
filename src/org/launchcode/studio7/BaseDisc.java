package org.launchcode.studio7;

import java.util.ArrayList;

public abstract class BaseDisc {

    public String name;
    public int storageCapacity;
    public int remainingCapacity;
    public int capacityUsed;
    public String diskType;
    public ArrayList<String> contents;

    public BaseDisc(String name, int storageCapacity, int capacityUsed, String diskType) {
        this.name = name;
        this.storageCapacity = storageCapacity;
        this.remainingCapacity = spaceLeft();
        this.capacityUsed = capacityUsed;
        this.diskType = diskType;
    }

    private int checkCapacity(int dataWritten) {
        if (storageCapacity < dataWritten) {
            return storageCapacity;
        }
        return dataWritten;
    }

    private int spaceLeft() {
        return storageCapacity - capacityUsed;
    }

    public String diskInfo() {
        String output = String.format(
                "\nDisk name: %s" +
                "\nMax capacity: %d" +
                "\nSpace used: %d" +
                "\nAvailable space: %d\n", name, storageCapacity, capacityUsed, remainingCapacity);
        return output;
    }

    public String writeData(int dataSize) {
        if (dataSize > remainingCapacity) {
            return "Not enough disc space!";
        }
        capacityUsed += dataSize;
        remainingCapacity -= dataSize;
        return "Data successfully written to disc. Remaining space = " + remainingCapacity;
    }
}
