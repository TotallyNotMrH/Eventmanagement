package informatik.campus.eventmanagement.db.sponsor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import informatik.campus.eventmanagement.db.event.Event;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firmenname;
    private double gezahlterBetrag;
    @ManyToMany(mappedBy = "sponsoren", fetch =  FetchType.LAZY)
    @JsonBackReference //Ohne das und das Gegenstück in Event bekommen wir eine Endlos-Schleife
    private Set<Event> events;
    public Sponsor() {}
    public Sponsor(String firmename, double gezahlterBetrag) {
        this.firmenname = firmename;
        this.gezahlterBetrag = gezahlterBetrag;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public double getGezahlterBetrag() {
        return gezahlterBetrag;
    }

    public void setGezahlterBetrag(double gezahlterBetrag) {
        this.gezahlterBetrag = gezahlterBetrag;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "id=" + id +
                ", firmenname='" + firmenname + '\'' +
                ", gezahlterBetrag=" + gezahlterBetrag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return id == sponsor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
