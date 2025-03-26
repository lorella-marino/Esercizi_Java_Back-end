package it.epicode.gestione_eventi;


import it.epicode.gestione_eventi.eventi.Evento;
import it.epicode.gestione_eventi.eventi.EventoDAO;
import it.epicode.gestione_eventi.eventi.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
    EntityManager em = emf.createEntityManager();

    EventoDAO eventoDAO = new EventoDAO(em);

    Evento evento = new Evento("Evento1", LocalDate.now(), "Descrizione1", TipoEvento.PUBBLICO, 50);
    Evento evento2 = new Evento("Evento2", LocalDate.now(), "Descrizione2", TipoEvento.PRIVATO, 110);
    Evento evento3 = new Evento("Evento3", LocalDate.now(), "Descrizione3", TipoEvento.PUBBLICO, 120);
    Evento evento4 = new Evento("Evento4", LocalDate.now(), "Descrizione4", TipoEvento.PRIVATO, 85);

    em.getTransaction().begin();

    eventoDAO.insert(evento);
    eventoDAO.insert(evento2);
    eventoDAO.insert(evento3);
    eventoDAO.insert(evento4);

    eventoDAO.find(1L);

    eventoDAO.delete( 4L );

    em.getTransaction().commit();

    em.close();
    emf.close();
}

}
