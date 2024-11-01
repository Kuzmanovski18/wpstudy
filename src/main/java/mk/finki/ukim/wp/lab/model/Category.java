package mk.finki.ukim.wp.lab.model;

import lombok.Data;

@Data
public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
