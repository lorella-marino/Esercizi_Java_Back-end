package it.epicode.gestione_eventi_s3_l3.location;

import jakarta.persistence.EntityManager;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Location location) {
        em.persist(location);
        System.out.println("Location salvata correttamente!");
    }

    public void update(Location location) {
        em.merge(location);
        System.out.println("Location modificata correttamente!");
    }

    public Location find(Long id) {
        return em.find(Location.class, id);
    }

    public void delete(Long id) {
        Location a = find(id);
        em.remove(a);
        System.out.println("Location eliminata correttamente!");
    }
}
