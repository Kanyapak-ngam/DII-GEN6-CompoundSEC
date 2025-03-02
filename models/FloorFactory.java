/// FloorFactory.java (Factory Pattern)
package models;

public class FloorFactory {
    public static FloorFactory getFloor(String type) {
        switch (type) {
            case "Low": return new LowFloor();
            case "Medium": return new MediumFloor();
            case "High": return new HighFloor();
            default: throw new IllegalArgumentException("Invalid Floor Type");
        }
    }
}
