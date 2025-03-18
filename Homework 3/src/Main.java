import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Airliner A1 = new Airliner("Vulturu", "F-150", "1029", 40);
        Freighter F1 = new Freighter("Turbo", "Diesel", "1234", 100);
        Drone D1 = new Drone("Elodia", "Musca", "5678", 100, 50);

        CargoCapable[] Cargo = {F1, D1};

        Airport airport = new Airport(2);
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("FL123", A1, LocalTime.of(10, 0), LocalTime.of(10, 30)));
        flights.add(new Flight("FL456", F1, LocalTime.of(10, 15), LocalTime.of(10, 45)));
        flights.add(new Flight("FL789", D1, LocalTime.of(10, 45), LocalTime.of(11, 0)));

        SchedulingProblem problem = new SchedulingProblem(airport, flights);
        Map<Flight, Runway> schedule = problem.solve();

        System.out.println("Flight Schedule:");
        for (Map.Entry<Flight, Runway> entry : schedule.entrySet()) {
            System.out.println(entry.getKey().getFlightNumber() + " -> " + entry.getValue().getId());
        }
    }
}