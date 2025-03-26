package it.epicode.gestione_eventi_s3_l3;


import it.epicode.gestione_eventi_s3_l3.evento.Evento;
import it.epicode.gestione_eventi_s3_l3.evento.EventoDAO;
import it.epicode.gestione_eventi_s3_l3.evento.TipoEvento;
import it.epicode.gestione_eventi_s3_l3.location.Location;
import it.epicode.gestione_eventi_s3_l3.location.LocationDAO;
import it.epicode.gestione_eventi_s3_l3.partecipazione.Partecipazione;
import it.epicode.gestione_eventi_s3_l3.partecipazione.PartecipazioneDAO;
import it.epicode.gestione_eventi_s3_l3.partecipazione.Stato;
import it.epicode.gestione_eventi_s3_l3.persona.Persona;
import it.epicode.gestione_eventi_s3_l3.persona.PersonaDAO;
import it.epicode.gestione_eventi_s3_l3.persona.Sesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
    EntityManager em = emf.createEntityManager();

    EventoDAO eventoDAO = new EventoDAO(em);
    PersonaDAO personaDAO = new PersonaDAO(em);
    LocationDAO locationDAO = new LocationDAO(em);
    PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

    em.getTransaction().begin();

    Evento evento = new Evento("Concerto", LocalDate.of(2023, 12, 15), "Concerto musica rock", null, null, TipoEvento.PUBBLICO, 1000);
    Persona persona = new Persona("Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 5, 10), Sesso.M, null);
    Location location = new Location ("Stadio", "Via Roma 1", null );


    eventoDAO.insert(evento);
    personaDAO.insert(persona);
    locationDAO.insert(location);


    Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.CONFERMATA);

    partecipazioneDAO.insert( partecipazione );

    em.getTransaction().commit();

    em.close();
    emf.close();
}

}
