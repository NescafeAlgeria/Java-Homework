abstract class Aircraft implements Comparable<Aircraft>{
    protected String name;
    protected String model;
    protected String tailNumber;

    public Aircraft(String name, String model, String tailNumber) {
        this.name = name;
        this.model = model;
        this.tailNumber = tailNumber;
    }
    public String getName() { return name; }
    public String getModel() { return model; }
    public String getTailNumber() { return tailNumber; }

    @Override
    public int compareTo(Aircraft o) {
        return this.name.compareTo(o.name);
    }
}


