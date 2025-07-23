package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.adresse.Adresse;
import informatik.campus.eventmanagement.db.adresse.AdresseRepository;
import informatik.campus.eventmanagement.db.benutzer.Benutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adressen")
public class AdresseController {
    private final AdresseRepository adresseRepository;
    @Autowired
    public AdresseController(AdresseRepository adresseRepository) {this.adresseRepository = adresseRepository;}

    @GetMapping("/all")
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    @PostMapping("/new")
    public Adresse save(@RequestBody Adresse adresse) {
        return adresseRepository.save(adresse);
    }
    @GetMapping("/{id}")
    public Adresse findById(@PathVariable long id) {
        return adresseRepository.findAdresseById(id);
    }
    @PostMapping
    public void create(@RequestBody Adresse adresse) {
        adresseRepository.save(adresse);
    }
    @DeleteMapping
    public void delete(@RequestBody Adresse adresse) {
        adresseRepository.delete(adresse);
    }
}
