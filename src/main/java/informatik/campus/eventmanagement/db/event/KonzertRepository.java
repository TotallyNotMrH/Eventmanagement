package informatik.campus.eventmanagement.db.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonzertRepository extends JpaRepository<Konzert, Long>{
    Konzert findKonzertById(Long id);
}
