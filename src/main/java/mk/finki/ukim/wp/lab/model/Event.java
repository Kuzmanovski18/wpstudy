package mk.finki.ukim.wp.lab.model;

import lombok.Data;

@Data
public class Event {
    private String name;
    private String description;
    private double popularityScore;

    public Event(String name, String description, double popularityScore) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
    }
}
