package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.adresse.Adresse;
import informatik.campus.eventmanagement.db.benutzer.Benutzer;
import informatik.campus.eventmanagement.db.benutzer.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class BenutzerController {
    private final BenutzerRepository benutzerRepository;
    @Autowired
    public BenutzerController(BenutzerRepository benutzerRepository) {
        this.benutzerRepository = benutzerRepository;
    }
    @GetMapping("/all")
    public List<Benutzer> findAll() {return benutzerRepository.findAll();}

    @PostMapping("/new")
    public Benutzer save(@RequestBody Benutzer benutzer) {
        return benutzerRepository.save(benutzer);
    }

    @GetMapping("/{id}")
    public Benutzer findById(@PathVariable long id) {
        return benutzerRepository.findUserById(id);
    }
    @PostMapping
    public void create(@RequestBody Benutzer benutzer) {
        benutzerRepository.save(benutzer);
    }
    @DeleteMapping
    public void delete(@RequestBody Benutzer benutzer) {
        benutzerRepository.delete(benutzer);
    }
    @GetMapping("/{name}")
    public Benutzer findByName(@PathVariable String name) {
        return benutzerRepository.findBenutzerByName(name);
    }

}
