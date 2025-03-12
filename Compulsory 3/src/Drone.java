public class Drone extends Aircraft implements CargoCapable {
    private int batteryLife;
    private int maxPayload;

    public Drone(String name, String model, String tailNumber, int batteryLife, int maxPayload) {
        super(name, model, tailNumber);
        this.batteryLife = batteryLife;
        this.maxPayload = maxPayload;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    @Override
    public int getCargoCapacity() {
        return maxPayload;
    }
}