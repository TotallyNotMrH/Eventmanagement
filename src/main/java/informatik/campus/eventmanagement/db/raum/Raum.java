package informatik.campus.eventmanagement.db.raum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Raum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int anzahlSitzplaetze;
    private String bezeichnung;
    private int anzahlReihe;
    public Raum() {}

    public Raum(int anzahlSitzplaetze, int anzahlReihe, String bezeichnung) {
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.anzahlReihe = anzahlReihe;
        this.bezeichnung = bezeichnung;
    }

    public int getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }

    public void setAnzahlSitzplaetze(int anzahlSitzplaetze) {
        this.anzahlSitzplaetze = anzahlSitzplaetze;
    }

    public int getAnzahlReihe() {
        return anzahlReihe;
    }

    public void setAnzahlReihe(int anzahlReihe) {
        this.anzahlReihe = anzahlReihe;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public int getId() {
        return id;
    }
}
