import java.util.*;
import java.time.LocalTime;

class SchedulingProblem {
    private Airport airport;
    private List<Flight> flights;

    public SchedulingProblem(Airport airport, List<Flight> flights) {
        this.airport = airport;
        this.flights = flights;
    }

        public Map<Flight, Runway> solve() {
            Map<Flight, Runway> schedule = new HashMap<>();
            List<Runway> availableRunways = airport.getRunways();

            flights.sort(Comparator.comparing(Flight::getLandingStart));

            Map<Runway, LocalTime> lastUsedTime = new HashMap<>();
            for (Runway r : availableRunways) {
                lastUsedTime.put(r, LocalTime.MIN);
            }

            for (Flight flight : flights) {
                for (Runway runway : availableRunways) {
                    if (flight.getLandingStart().isAfter(lastUsedTime.get(runway))) {
                        schedule.put(flight, runway);
                        lastUsedTime.put(runway, flight.getLandingEnd());
                        break;
                    }
                }
            }

        return schedule;
    }
}