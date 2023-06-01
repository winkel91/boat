package winkel.sailing.boat.model;

import jakarta.persistence.*;

@Entity
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String lengthClass;

    private int points;

    // Default constructor (required by JPA)
    public Boat() {
    }

    // Parameterized constructor
    public Boat(String name, String lengthClass, int points) {
        this.name = name;
        this.lengthClass = lengthClass;
        this.points = points;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLengthClass() {
        return lengthClass;
    }

    public void setLengthClass(String lengthClass) {
        this.lengthClass = lengthClass;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}