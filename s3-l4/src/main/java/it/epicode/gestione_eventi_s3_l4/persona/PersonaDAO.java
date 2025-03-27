package it.epicode.gestione_eventi_s3_l4.persona;

import jakarta.persistence.EntityManager;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Persona persona) {
        em.persist(persona);
        System.out.println("Persona salvata correttamente!");
    }

    public void update(Persona persona) {
        em.merge(persona);
        System.out.println("Persona modificata correttamente!");
    }

    public Persona find(Long id) {
        return em.find(Persona.class, id);
    }

    public void delete(Long id) {
        Persona a = find(id);
        em.remove(a);
        System.out.println("Persona eliminata correttamente!");
    }
}
