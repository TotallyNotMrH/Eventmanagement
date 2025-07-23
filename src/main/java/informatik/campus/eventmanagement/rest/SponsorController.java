package informatik.campus.eventmanagement.rest;

import informatik.campus.eventmanagement.db.sponsor.Sponsor;
import informatik.campus.eventmanagement.db.sponsor.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sponsoren")
public class SponsorController {
    private final SponsorRepository sponsorRepository;
    @Autowired
    public SponsorController(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }
    @GetMapping("/all")
    public List<Sponsor> findAll() {return sponsorRepository.findAll();}

    @PostMapping("/new")
    public Sponsor save(@RequestBody Sponsor sponsor) {return sponsorRepository.save(sponsor);}

    @GetMapping("/{id}")
    public Sponsor findById(@PathVariable Long id) {return sponsorRepository.findSponsorById(id);}
}
