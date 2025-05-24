package entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "countries")
@NamedQuery(name = "Country.findByName",
        query = "SELECT c FROM Country c WHERE LOWER(c.name) LIKE LOWER(:name)")
public class Country {
    @Id
    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    private int id;

    @Column(nullable = false)
    private String name;

    private String code;

    @ManyToOne
    @JoinColumn(name = "continent")
    @JsonIgnore
    private Continent continent;

    // Constructors, Getters, Setters
    public Country() {}
    public Country(String name, String code, Continent continent) {
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public Continent getContinent() { return continent; }

    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
    public void setContinent(Continent continent) { this.continent = continent; }
}
