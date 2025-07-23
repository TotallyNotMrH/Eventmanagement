package informatik.campus.eventmanagement.db.Ticket;

import informatik.campus.eventmanagement.db.benutzer.Benutzer;
import informatik.campus.eventmanagement.db.event.Event;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sitzplatz;
    private double preis;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "benutzer_id")
    private Benutzer benutzer;

    public Ticket() {}

    public Ticket(String sitzplatz, double preis, Event event, Benutzer benutzer) {
        this.sitzplatz = sitzplatz;
        this.preis = preis;
        this.event = event;
        this.benutzer = benutzer;
    }

    public String getSitzplatz() {
        return sitzplatz;
    }

    public void setSitzplatz(String sitzplatz) {
        this.sitzplatz = sitzplatz;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", sitzplatz='" + sitzplatz + '\'' +
                ", preis=" + preis +
                ", event=" + event +
                ", benutzer=" + benutzer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
