package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
@NamedQuery(name = "Continent.findByName",
        query = "SELECT c FROM Continent c WHERE LOWER(c.name) LIKE LOWER(:name)")
public class Continent {
    @Id
    @SequenceGenerator(name = "continent_seq", sequenceName = "continent_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continent_seq")
    private int id;

    @Column(nullable = false)
    private String name;

    // Constructors, Getters, Setters
    public Continent() {}
    public Continent(String name) { this.name = name; }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
