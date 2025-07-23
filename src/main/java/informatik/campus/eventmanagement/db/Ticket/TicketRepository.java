package informatik.campus.eventmanagement.db.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    Ticket getTicketById(long id);


    void deleteTicketById(long id);

    List<Ticket> findAllByEvent_Id(long eventId);
}
