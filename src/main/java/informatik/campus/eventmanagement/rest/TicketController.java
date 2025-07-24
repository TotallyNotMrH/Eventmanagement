package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.Ticket.Ticket;
import informatik.campus.eventmanagement.db.Ticket.TicketRepository;
import informatik.campus.eventmanagement.db.benutzer.BenutzerRepository;
import informatik.campus.eventmanagement.db.event.EventRepository;
import informatik.campus.eventmanagement.db.raum.RaumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final BenutzerRepository benutzerRepository;
    private final RaumRepository raumRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository, EventRepository eventRepository, BenutzerRepository benutzerRepository, RaumRepository raumRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.benutzerRepository = benutzerRepository;
        this.raumRepository = raumRepository;
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
    /*
    Hier wird ein neues Ticket hinzugefügt, allerdings nur wenn es diesen SItzplatz noch gibt
     */
    @PostMapping
    public boolean createTicket(@RequestBody Ticket ticket) {
        int anzPlaetze = raumRepository.findRaumById(ticket.getRaum().getId()).getAnzahlSitzplaetze();
        if(ticket.getSitzplatz()>anzPlaetze){
            return false;
        }else{
            ticketRepository.save(ticket);
            return true;
        }
    }
    @PostMapping("/{benutzerid}/{eventid}")
    public Ticket createTicket(@RequestBody Ticket ticket,  @PathVariable int benutzerid, @PathVariable int eventid) {
       ticket.setBenutzer(benutzerRepository.findUserById(benutzerid));
       ticket.setEvent(eventRepository.findEventById(eventid));
        return ticketRepository.save(ticket);
    }
    @GetMapping("/{konzertid}")
    public List<Ticket> getTicketsByKonzert(@PathVariable int konzerid) {
        return ticketRepository.findAllByEvent_Id(konzerid);
    }
}
