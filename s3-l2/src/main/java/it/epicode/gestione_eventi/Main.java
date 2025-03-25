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

    eventoDAO.save(new Evento( "Evento1", LocalDate.now(), "Descrizione1", TipoEvento.PUBBLICO, 50));
    eventoDAO.save(new Evento( "Evento2", LocalDate.now(), "Descrizione2", TipoEvento.PRIVATO, 110));
    eventoDAO.save(new Evento( "Evento3", LocalDate.now(), "Descrizione3", TipoEvento.PUBBLICO, 120));
    eventoDAO.save(new Evento( "Evento4", LocalDate.now(), "Descrizione4", TipoEvento.PRIVATO, 85));

    eventoDAO.getById(1L);

    eventoDAO.delete( eventoDAO.getById(4L) );

    em.close();
    emf.close();
}

}
