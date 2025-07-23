package informatik.campus.eventmanagement.rest;


import informatik.campus.eventmanagement.db.event.Konzert;
import informatik.campus.eventmanagement.db.event.KonzertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/konzerte")
public class KonzertController {
    private final KonzertRepository konzertRepository;
    @Autowired
    public KonzertController(KonzertRepository konzertRepository) {
        this.konzertRepository = konzertRepository;
    }
    @GetMapping("/all")
    public List<Konzert> findAll() {
        return konzertRepository.findAll();
    }
    @GetMapping("/{id}")
    public Konzert getConcertById(@PathVariable Long id) {
        return konzertRepository.findKonzertById(id);
    }

}
