package informatik.campus.eventmanagement.db.benutzer;


import informatik.campus.eventmanagement.db.adresse.Adresse;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;


import java.util.Objects;

@Entity
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.MERGE)
    private Adresse adresse;

    public Benutzer(String name, String email, Adresse adresse) {
        this.adresse = adresse;
        this.name = name;
        this.email = email;
    }
    public Benutzer() {}
    private Benutzer(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return id == benutzer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
