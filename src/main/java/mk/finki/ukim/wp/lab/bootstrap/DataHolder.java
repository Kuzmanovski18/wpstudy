package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Category;
import mk.finki.ukim.wp.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init() {

        categories.add(new Category(0, "Sports"));
        categories.add(new Category(1,"Foods"));
        categories.add(new Category(2,"Music"));
        categories.add(new Category(3,"Films"));
        categories.add(new Category(4,"Studies"));
        categories.add(new Category(5,"Other"));

        events.add(new Event("Concert Night", "Enjoy a night filled with music and dance.", 8.5, categories.get(2))); // Music
        events.add(new Event("Food Festival", "Taste delicious food from around the world.", 9.0, categories.get(1))); // Foods
        events.add(new Event("Tech Conference", "Discover the latest in technology and innovation.", 7.8, categories.get(4))); // Studies
        events.add(new Event("Art Exhibition", "Explore contemporary and classical art pieces.", 8.2, categories.get(5))); // Other
        events.add(new Event("Book Fair", "Find books from various genres and meet authors.", 7.5, categories.get(4))); // Studies
        events.add(new Event("Film Screening", "Watch critically acclaimed movies.", 8.0, categories.get(3))); // Films
        events.add(new Event("Yoga Workshop", "Learn the basics of yoga and mindfulness.", 6.9, categories.get(0))); // Sports
        events.add(new Event("Photography Course", "Improve your photography skills with experts.", 7.3, categories.get(4))); // Studies
        events.add(new Event("Marathon", "Participate in the annual city marathon.", 8.7, categories.get(0))); // Sports
        events.add(new Event("Science Fair", "Discover fascinating science projects and experiments.", 8.1, categories.get(4))); // Studies
    }
}
