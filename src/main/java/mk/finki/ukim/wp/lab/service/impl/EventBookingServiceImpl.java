package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Event;
import mk.finki.ukim.wp.lab.model.EventBooking;
import mk.finki.ukim.wp.lab.repository.EventRepository;
import mk.finki.ukim.wp.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    private final EventRepository eventRepository;

    public EventBookingServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        Event event = eventRepository.findAll().stream()
                .filter(e -> e.getName().equals(eventName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);
    }
}
