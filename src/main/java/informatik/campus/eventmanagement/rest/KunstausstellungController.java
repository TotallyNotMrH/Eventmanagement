package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.event.Kunstausstellung;
import informatik.campus.eventmanagement.db.event.KunstausstellungRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunst")
public class KunstausstellungController {
    private KunstausstellungRepostitory kunstausstellungRepostitory;
    @Autowired
    public KunstausstellungController(KunstausstellungRepostitory repository) {
        this.kunstausstellungRepostitory = repository;
    }
    @GetMapping("/all")
    public List<Kunstausstellung> findAll() {
        return this.kunstausstellungRepostitory.findAll();
    }
    @GetMapping("/{id}")
    public Kunstausstellung findOne(@PathVariable Integer id) {
        return this.kunstausstellungRepostitory.findById(id).orElse(null);
    }
    @PostMapping
    public Kunstausstellung create(@RequestBody Kunstausstellung kunstausstellung) {
        return kunstausstellungRepostitory.save(kunstausstellung);
    }
    @DeleteMapping
    public void delete(@RequestBody Kunstausstellung kunstausstellung) {
        kunstausstellungRepostitory.delete(kunstausstellung);
    }
}
