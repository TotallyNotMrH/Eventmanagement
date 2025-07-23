package informatik.campus.eventmanagement.db.event;

import informatik.campus.eventmanagement.db.Ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    Event findEventById(long id);


}
