package informatik.campus.eventmanagement.db.event;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
@Entity
public class Kunstausstellung extends Event{
    private String stilrichtung;
    private String kuenstler;

    public Kunstausstellung(String titel, LocalDateTime datum, String ort, String stilrichtung, String kuenstler) {
        super(titel, datum, ort);
        this.stilrichtung = stilrichtung;
        this.kuenstler = kuenstler;
    }

    public Kunstausstellung() {
        
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }

    public String getStilrichtung() {
        return stilrichtung;
    }

    public void setStilrichtung(String stilrichtung) {
        this.stilrichtung = stilrichtung;
    }
}
