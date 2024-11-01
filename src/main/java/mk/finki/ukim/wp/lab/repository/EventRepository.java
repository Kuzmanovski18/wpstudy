package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Category;
import mk.finki.ukim.wp.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text){
        return DataHolder.events.stream().filter(event -> event.getName().contains(text) ||
                event.getDescription().contains(text)).toList();

    }

    public List<Event> getEventsByCategory(Category category) {
        return DataHolder.events.stream()
                .filter(event -> event.getCategory().equals(category)).toList();
    }
}
