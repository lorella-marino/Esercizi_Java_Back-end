package it.epicode.gestione_eventi;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
    EntityManager em = emf.createEntityManager();

    EventoDAO eventoDAO = new EventoDAO(em);

    Evento evento = new Evento( "Evento1", LocalDate.now(), "Descrizione1", TipoEvento.PUBBLICO, 50);
    Evento evento2 = new Evento( "Evento2", LocalDate.now(), "Descrizione2", TipoEvento.PRIVATO, 100);
    Evento evento3 = new Evento( "Evento3", LocalDate.now(), "Descrizione3", TipoEvento.PUBBLICO, 120);
    Evento evento4 = new Evento( "Evento4", LocalDate.now(), "Descrizione4", TipoEvento.PRIVATO, 85);

    eventoDAO.save( evento );
    eventoDAO.save( evento2 );
    eventoDAO.save( evento3 );
    eventoDAO.save( evento4 );
    eventoDAO.getById(1L);

    eventoDAO.delete( evento4 );



        em.close();
        emf.close();
}

}
