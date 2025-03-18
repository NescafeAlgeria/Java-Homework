import java.util.*;

class Airport {
    private List<Runway> runways;

    public Airport(int numRunways) {
        runways = new ArrayList<>();
        for (int i = 1; i <= numRunways; i++) {
            runways.add(new Runway("Runway " + i));
        }
    }

    public List<Runway> getRunways() {
        return runways;
    }
}