package informatik.campus.eventmanagement.db.sponsor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    Sponsor findSponsorById(long id);
}
