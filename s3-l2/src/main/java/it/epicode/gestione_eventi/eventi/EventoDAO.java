package it.epicode.gestione_eventi.eventi;

import jakarta.persistence.EntityManager;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Evento evento) {
        em.persist(evento);
        System.out.println("Evento salvato correttamente!");
    }

    public Evento find(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento a = find(id);
        em.remove(a);
        System.out.println("Evento eliminato correttamente!");
    }

}
