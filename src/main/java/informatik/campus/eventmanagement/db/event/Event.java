package informatik.campus.eventmanagement.db.event;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import informatik.campus.eventmanagement.db.sponsor.Sponsor;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String titel;
    protected LocalDateTime datum;
    protected String ort;
    protected String bildURL;
    @ManyToMany(cascade = CascadeType.REFRESH,  fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinTable(name = "sponsor_id",
    joinColumns = @JoinColumn(name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "sponsor_id"))
    protected Set<Sponsor> sponsoren = new HashSet<>();

    public Event() {
    }

    public Event(String titel, LocalDateTime datum, String ort, String bildURL) {
        this.titel = titel;
        this.datum = datum;
        this.ort = ort;
        this.bildURL = bildURL;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Set<Sponsor> getSponsoren() {
        return sponsoren;
    }

    public void setSponsoren(Set<Sponsor> sponsoren) {
        this.sponsoren = sponsoren;
    }

    public long getId() {
        return id;
    }

    public String getBildURL() {
        return bildURL;
    }

    public void setBildURL(String bildURL) {
        this.bildURL = bildURL;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", datum=" + datum +
                ", ort='" + ort + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
