package informatik.campus.eventmanagement.db.adresse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

    Adresse findAdresseById(Long id);

    String getAdressesById(Long id);
}
