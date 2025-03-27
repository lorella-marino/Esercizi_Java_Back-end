package it.epicode.gestione_eventi_s3_l4;


import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import it.epicode.gestione_eventi_s3_l4.evento.EventoDAO;
import it.epicode.gestione_eventi_s3_l4.evento.TipoEvento;
import it.epicode.gestione_eventi_s3_l4.evento.concerto.Concerto;
import it.epicode.gestione_eventi_s3_l4.evento.concerto.Genere;
import it.epicode.gestione_eventi_s3_l4.evento.gara.GaraDiAtletica;
import it.epicode.gestione_eventi_s3_l4.evento.partita.PartitaDiCalcio;
import it.epicode.gestione_eventi_s3_l4.location.Location;
import it.epicode.gestione_eventi_s3_l4.location.LocationDAO;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import it.epicode.gestione_eventi_s3_l4.partecipazione.PartecipazioneDAO;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Stato;
import it.epicode.gestione_eventi_s3_l4.persona.Persona;
import it.epicode.gestione_eventi_s3_l4.persona.PersonaDAO;
import it.epicode.gestione_eventi_s3_l4.persona.Sesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
    EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);


        Persona vincitore = new Persona(null, "Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 1, 1), Sesso.M, null, null, null );
        Persona atleta = new Persona(null, "Luigi", "Verdi", "luigi.verdi@example.com", LocalDate.of(1995, 2, 2), Sesso.M, null, null, null);

        PartitaDiCalcio partita1 = new PartitaDiCalcio(null, "Partita di calcio 1", LocalDate.of(2021, 4, 15), "Descrizione 1", null, null, TipoEvento.PUBBLICO, 22, "Squadra di casa", "Squadra ospite", "Squadra vincente", 2, 1);
        PartitaDiCalcio partita2 = new PartitaDiCalcio(null, "Partita di calcio 2", LocalDate.of(2022, 4, 15), "Descrizione 2", null, null, TipoEvento.PRIVATO, 50, "Squadra di casa", "Squadra ospite", null, 2, 1);
        PartitaDiCalcio partita3 = new PartitaDiCalcio(null, "Partita di calcio 3", LocalDate.of(2023, 4, 15), "Descrizione 3", null, null, TipoEvento.PUBBLICO, 32, "Squadra di casa", "Squadra ospite", "Squadra vincente", 2, 1);

        Concerto concerto1 = new Concerto(null, "Concerto 1", LocalDate.of(2024, 4, 15), "Descrizione 1", null, null, TipoEvento.PUBBLICO, 60, Genere.POP, true);
        Concerto concerto2 = new Concerto(null, "Concerto 2", LocalDate.of(2025, 4, 15), "Descrizione 2", null, null, TipoEvento.PRIVATO, 79, Genere.ROCK, false);
        Concerto concerto3 = new Concerto(null, "Concerto 3", LocalDate.of(2026, 4, 15), "Descrizione 3", null, null, TipoEvento.PUBBLICO, 54, Genere.CLASSICO, true);

        GaraDiAtletica gara1 = new GaraDiAtletica(null, "Gara di atletica 1", LocalDate.of(2027, 4, 15), "Descrizione 1", null, null, TipoEvento.PUBBLICO, 100, null, vincitore);
        GaraDiAtletica gara2 = new GaraDiAtletica(null, "Gara di atletica 2", LocalDate.of(2028, 4, 15), "Descrizione 2", null, null, TipoEvento.PRIVATO, 200, null, atleta);
        GaraDiAtletica gara3 = new GaraDiAtletica(null, "Gara di atletica 3", LocalDate.of(2029, 4, 15), "Descrizione 3", null, null, TipoEvento.PUBBLICO, 300, null, null);

        em.getTransaction ().begin();

        em.persist(vincitore);
        em.persist(atleta);

        em.persist(concerto1);
        em.persist(concerto2);
        em.persist(concerto3);

        em.persist(partita1);
        em.persist(partita2);
        em.persist(partita3);

        em.persist(gara1);
        em.persist(gara2);
        em.persist(gara3);

        em.getTransaction().commit();

        List <Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming( true );
        concertiInStreaming.forEach(System.out::println);

        List <Concerto> concertiPerGenere = eventoDAO.getConcertiPerGenere( Genere.POP );
        concertiPerGenere.forEach(System.out::println);

        List <PartitaDiCalcio> partiteVinteInCasa = eventoDAO.getPartiteVinteInCasa( "Squadra di casa" );
        partiteVinteInCasa.forEach(System.out::println);

        List <PartitaDiCalcio> partiteVinteInTrasferta = eventoDAO.getPartiteVinteInTrasferta( "Squadra ospite" );
        partiteVinteInTrasferta.forEach(System.out::println);

        List <PartitaDiCalcio> partitePareggiate = eventoDAO.getPartitePareggiate();
        partitePareggiate.forEach(System.out::println);

        List <GaraDiAtletica> gareDiAtleticaPerVincitore  = eventoDAO.getGareDiAtleticaPerVincitore( vincitore );
        gareDiAtleticaPerVincitore.forEach(System.out::println);

        List <GaraDiAtletica> gareDiAtleticaPerPartecipante  = eventoDAO.getGareDiAtleticaPerPartecipante( atleta );
        gareDiAtleticaPerPartecipante.forEach(System.out::println);

        List <Evento> eventiSoldOut = eventoDAO.getEventiSoldOut();
        eventiSoldOut.forEach(System.out::println);

        List <Partecipazione> PartecipazioneDaConfermarePerEvento = eventoDAO.PartecipazioneDaConfermarePerEvento( 1L );
        PartecipazioneDaConfermarePerEvento.forEach(System.out::println);



        em.close();
        emf.close();
}

}
