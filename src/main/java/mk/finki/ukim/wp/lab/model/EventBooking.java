package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EventBooking {
    private String eventName;
    private String attendeeName;
    private String attendeeAddress;
    private long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        this.attendeeAddress = attendeeAddress;
        this.attendeeName = attendeeName;
        this.eventName = eventName;
    }
}
