package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.raum.Raum;
import informatik.campus.eventmanagement.db.raum.RaumRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RaumController {
    private RaumRepository raumRepository;
    public RaumController(RaumRepository raumRepository) {
        this.raumRepository = raumRepository;
    }
    @GetMapping
    public List<Raum> findAll() {
        return raumRepository.findAll();
    }
}
