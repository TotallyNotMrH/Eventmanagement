package informatik.campus.eventmanagement.db.raum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaumRepository extends JpaRepository<Raum, Integer> {
    Raum findRaumById(int id);
}
