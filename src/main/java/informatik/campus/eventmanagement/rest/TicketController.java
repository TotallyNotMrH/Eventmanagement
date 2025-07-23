package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.Ticket.Ticket;
import informatik.campus.eventmanagement.db.Ticket.TicketRepository;
import informatik.campus.eventmanagement.db.benutzer.BenutzerRepository;
import informatik.campus.eventmanagement.db.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final BenutzerRepository benutzerRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository, EventRepository eventRepository, BenutzerRepository benutzerRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.benutzerRepository = benutzerRepository;
    }
    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        return ticketRepository.getTicketById(id);
    }
    @DeleteMapping
    public void deleteTicketById(@RequestParam int id) {
        ticketRepository.deleteTicketById(id);
    }
    @GetMapping("/event/{id}")
    public List<Ticket> getTicketsByEventId(@PathVariable int id) {
        return ticketRepository.findAllByEvent_Id(id);
    }
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    @PostMapping("/{benutzerid}/{eventid}")
    public Ticket createTicket(@RequestBody Ticket ticket,  @PathVariable int benutzerid, @PathVariable int eventid) {
       ticket.setBenutzer(benutzerRepository.findUserById(benutzerid));
       ticket.setEvent(eventRepository.findEventById(eventid));
        return ticketRepository.save(ticket);
    }
}
