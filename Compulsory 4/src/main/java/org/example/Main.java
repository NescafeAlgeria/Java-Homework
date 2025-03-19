package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("Alpha Base", LocationType.FRIENDLY),
                new Location("Bravo Post", LocationType.NEUTRAL),
                new Location("Charlie Zone", LocationType.ENEMY),
                new Location("Delta Outpost", LocationType.FRIENDLY),
                new Location("Echo Site", LocationType.ENEMY),
                new Location("Foxtrot Camp", LocationType.FRIENDLY)
        );

        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.FRIENDLY)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Friendly locations (sorted):");
        friendlyLocations.forEach(System.out::println);

        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> loc.getType() == LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getType).thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("\nEnemy locations (sorted by type and name):");
        enemyLocations.forEach(System.out::println);
    }
}