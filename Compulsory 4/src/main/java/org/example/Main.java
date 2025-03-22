package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("A", LocationType.FRIENDLY),
                new Location("B", LocationType.NEUTRAL),
                new Location("C", LocationType.ENEMY),
                new Location("D", LocationType.FRIENDLY),
                new Location("E", LocationType.ENEMY),
                new Location("F", LocationType.FRIENDLY)
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