package informatik.campus.eventmanagement;

import informatik.campus.eventmanagement.db.Ticket.Ticket;
import informatik.campus.eventmanagement.db.Ticket.TicketRepository;
import informatik.campus.eventmanagement.db.adresse.Adresse;
import informatik.campus.eventmanagement.db.adresse.AdresseRepository;
import informatik.campus.eventmanagement.db.benutzer.Benutzer;
import informatik.campus.eventmanagement.db.benutzer.BenutzerRepository;
import informatik.campus.eventmanagement.db.event.EventRepository;
import informatik.campus.eventmanagement.db.event.Konzert;
import informatik.campus.eventmanagement.db.event.KonzertRepository;
import informatik.campus.eventmanagement.db.sponsor.Sponsor;
import informatik.campus.eventmanagement.db.sponsor.SponsorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class StartupRunner {
    private final AdresseRepository adresseRepository;
    private final SponsorRepository sponsorRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final BenutzerRepository benutzerRepository;
    private final KonzertRepository konzertRepository;

    @Autowired
    public StartupRunner(AdresseRepository adresseRepository, SponsorRepository sponsorRepository, EventRepository eventRepository, TicketRepository ticketRepository, BenutzerRepository benutzerRepository, KonzertRepository konzertRepository) {
        this.adresseRepository = adresseRepository;
        this.sponsorRepository = sponsorRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
        this.benutzerRepository = benutzerRepository;
        this.konzertRepository = konzertRepository;
    }

    @PostConstruct
    public void init() {
//        Adresse adresse1 = new Adresse("Pestalozzistraße", "2", "95676", "Wiesau");
//        adresseRepository.save(adresse1);
//        Adresse adresse2 = new Adresse("Pestalozzistraße", "3", "95676", "Wiesau");
//        adresseRepository.save(adresse2);
//        Adresse adresse3 = new Adresse("Teststrasse", "1", "95666", "Mitterteich");
//        adresseRepository.save(adresse3);
//        Adresse adresse4 = new Adresse("Mozartstraße", "22", "93215", "Hintertupfing");
//        adresseRepository.save(adresse4);
//
//        Benutzer benutzer = new Benutzer("Hugo Egon Balder", "hugo.egon@balder.de", adresse1);
//        benutzerRepository.save(benutzer);
//        Benutzer benutzer2 = new Benutzer("Manuel Neuer", "manu.neuer@fcbayern.de", adresse2);
//        benutzerRepository.save(benutzer2);
//        Benutzer benutzer3 = new Benutzer("Max Verstappen", "max.verst@redbull.com", adresse3);
//        benutzerRepository.save(benutzer3);
//        Benutzer benutzer4 = new Benutzer("Felix Neureuther", "felix.neureuther@ski.de",  adresse4);
//        benutzerRepository.save(benutzer4);
//
//        Konzert konzert = new Konzert("Rock in Staaz", LocalDateTime.of(2025, 7, 7, 18, 00, 00), "Kleinsterz", "ACDC", "Rock");
//        konzertRepository.save(konzert);
//        Konzert konzert2 = new Konzert("Bürgerfest", LocalDateTime.of(2025, 7, 11, 16, 00, 00), "Wiesau", "Lehrerband", "Mix");
//        konzertRepository.save(konzert2);
//
//        Ticket ticket = new Ticket("S1", 9.00, konzert, benutzer);
//        ticketRepository.save(ticket);
//        Ticket ticket2 = new Ticket("S2", 9.00, konzert, benutzer2);
//        ticketRepository.save(ticket2);
//        Ticket ticket3 = new Ticket("S8", 3.00, konzert2, benutzer);
//        ticketRepository.save(ticket3);
//        Ticket ticket4 = new Ticket("S4", 19.00, konzert2, benutzer4);
//        ticketRepository.save(ticket4);
//
//        Sponsor sponsor = new Sponsor("BSZ Wiesau", 3000.00);
//        konzert.getSponsoren().add(sponsor);
//        konzertRepository.save(konzert);
//        Sponsor sponsor2 = new Sponsor("Foerderverein TIR", 8000.00);
//        konzert2.getSponsoren().add(sponsor2);
//        konzert2.getSponsoren().add(sponsor);
//        konzertRepository.save(konzert2);
    }
}
