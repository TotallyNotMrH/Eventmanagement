package informatik.campus.eventmanagement.db.Ticket;

import informatik.campus.eventmanagement.db.benutzer.Benutzer;
import informatik.campus.eventmanagement.db.event.Event;
import informatik.campus.eventmanagement.db.raum.Raum;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int sitzplatz;
    private double preis;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "benutzer_id")
    private Benutzer benutzer;
    @ManyToOne
    @JoinColumn(name="raum")
    private Raum raum;


    public Ticket() {}

    public Ticket(int sitzplatz, double preis, Event event, Benutzer benutzer, Raum raum) {
        this.sitzplatz = sitzplatz;
        this.preis = preis;
        this.event = event;
        this.benutzer = benutzer;
        this.raum = raum;
    }

    public int getSitzplatz() {
        return sitzplatz;
    }

    public void setSitzplatz(int sitzplatz) {
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

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
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
