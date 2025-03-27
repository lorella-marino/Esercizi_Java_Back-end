package it.epicode.gestione_eventi_s3_l4.partecipazione;

import jakarta.persistence.EntityManager;

import java.util.List;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Partecipazione partecipazione) {
        em.persist(partecipazione);
        System.out.println("Partecipazione salvata correttamente!");
    }

    public void update(Partecipazione partecipazione) {
        em.merge(partecipazione);
        System.out.println("Partecipazione modificata correttamente!");
    }

    public Partecipazione find(Long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Long id) {
        Partecipazione a = find(id);
        em.remove(a);
        System.out.println("Partecipazione eliminata correttamente!");
    }
}
