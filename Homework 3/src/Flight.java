import java.time.LocalTime;

class Flight {
    private String flightNumber;
    private Aircraft aircraft;
    private LocalTime landingStart;
    private LocalTime landingEnd;

    public Flight(String flightNumber, Aircraft aircraft, LocalTime landingStart, LocalTime landingEnd) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.landingStart = landingStart;
        this.landingEnd = landingEnd;
    }

    public String getFlightNumber() { return flightNumber; }
    public Aircraft getAircraft() { return aircraft; }
    public LocalTime getLandingStart() { return landingStart; }
    public LocalTime getLandingEnd() { return landingEnd; }
}