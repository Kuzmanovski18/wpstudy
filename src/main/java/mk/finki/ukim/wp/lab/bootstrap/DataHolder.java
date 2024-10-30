package mk.finki.ukim.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.wp.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();

    @PostConstruct
    public void init() {
        events.add(new Event("Concert Night", "Enjoy a night filled with music and dance.", 8.5));
        events.add(new Event("Food Festival", "Taste delicious food from around the world.", 9.0));
        events.add(new Event("Tech Conference", "Discover the latest in technology and innovation.", 7.8));
        events.add(new Event("Art Exhibition", "Explore contemporary and classical art pieces.", 8.2));
        events.add(new Event("Book Fair", "Find books from various genres and meet authors.", 7.5));
        events.add(new Event("Film Screening", "Watch critically acclaimed movies.", 8.0));
        events.add(new Event("Yoga Workshop", "Learn the basics of yoga and mindfulness.", 6.9));
        events.add(new Event("Photography Course", "Improve your photography skills with experts.", 7.3));
        events.add(new Event("Marathon", "Participate in the annual city marathon.", 8.7));
        events.add(new Event("Science Fair", "Discover fascinating science projects and experiments.", 8.1));
    }
}
