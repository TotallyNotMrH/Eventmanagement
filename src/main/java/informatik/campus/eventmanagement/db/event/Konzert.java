package informatik.campus.eventmanagement.db.event;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Konzert extends Event {
    private String bandName;
    private String genre;

    public Konzert(String titel, LocalDateTime datum, String ort, String bildURL, String bandName, String genre) {
        super(titel, datum, ort, bildURL);
        this.bandName = bandName;
        this.genre = genre;
    }

    public Konzert() {

    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Konzert{" +
                "bandName='" + bandName + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }

}

