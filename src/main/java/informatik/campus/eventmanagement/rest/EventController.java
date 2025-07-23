package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.event.Event;
import informatik.campus.eventmanagement.db.event.EventRepository;
import informatik.campus.eventmanagement.db.sponsor.Sponsor;
import informatik.campus.eventmanagement.db.sponsor.SponsorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventRepository eventRepository;
    private SponsorRepository sponsorRepository;
    @Autowired
    public EventController(EventRepository eventRepository, SponsorRepository sponsorRepository) {
        this.eventRepository = eventRepository;
        this.sponsorRepository = sponsorRepository;
    }
    @Operation(summary = "get", description = "hole alle Events")
    @GetMapping("/all")
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
    @Operation(summary = "post", description = "Füge ein neues Event hinzu")
    @PostMapping("/new")
    public Event newEvent(@RequestBody Event newEvent) {
        return eventRepository.save(newEvent);
    }
    @Operation(summary = "post", description = "Füge einen neuen Sponsor zu dem Event mit der übergebenen id hinzu")
    @PostMapping("/{eventid}/sponsor")
    public void newEvent(@RequestBody Sponsor sponsor, @PathVariable int eventid) {
        eventRepository.findEventById(eventid).getSponsoren().add(sponsor);
    }
    @Operation(summary = "post", description = "füge dem Event mit der id den Sponsor mit der übergebenen id hinzu")
    @PostMapping("/{eventid}/{sponsorid}")
    public void newEvent(@PathVariable int eventid, @PathVariable int sponsorid) {
        eventRepository.findEventById(eventid).getSponsoren().add(sponsorRepository.findSponsorById(sponsorid));
    }
    @Operation(summary = "get", description = "hole das Event mit dieser id")
    @GetMapping("/{id}")
    public Event findOne(@PathVariable Long id) {
        return eventRepository.findEventById(id);
    }
    @Operation(summary = "delete", description = "lösche das Event mit dieser id")
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }

}
