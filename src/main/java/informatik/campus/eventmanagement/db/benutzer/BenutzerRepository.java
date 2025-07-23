package informatik.campus.eventmanagement.db.benutzer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

    Benutzer findUserById(long id);

    Benutzer findBenutzerByName(String name);
}
