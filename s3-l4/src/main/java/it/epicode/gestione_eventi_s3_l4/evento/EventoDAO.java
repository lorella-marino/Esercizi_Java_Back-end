package it.epicode.gestione_eventi_s3_l4.evento;

import it.epicode.gestione_eventi_s3_l4.evento.concerto.Concerto;
import it.epicode.gestione_eventi_s3_l4.evento.concerto.Genere;
import it.epicode.gestione_eventi_s3_l4.evento.gara.GaraDiAtletica;
import it.epicode.gestione_eventi_s3_l4.evento.partita.PartitaDiCalcio;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import it.epicode.gestione_eventi_s3_l4.persona.Persona;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Evento evento) {
        em.persist(evento);
        System.out.println("Evento salvato correttamente!");
    }

    public void update(Evento evento) {
        em.merge(evento);
        System.out.println("Evento modificato correttamente!");
    }

    public Evento find(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento a = find(id);
        em.remove(a);
        System.out.println("Evento eliminato correttamente!");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class)
                .setParameter("inStreaming", inStreaming)
                .getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                .setParameter("genere", genere)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(String squadraDiCasa) {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String squadraOspite) {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = null", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        return em.createQuery("SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore", GaraDiAtletica.class)
                .setParameter("vincitore", vincitore)
                .getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona atleta) {
        return em.createQuery("SELECT g FROM GaraDiAtletica g JOIN g.partecipazione p WHERE p.persona = :atleta", GaraDiAtletica.class)
                .setParameter("atleta", atleta)
                .getResultList();
    }

    public List<Evento> getEventiSoldOut ( int numeroMassimoPartecipanti ) {
        return em.createQuery("SELECT e FROM Evento e WHERE e.numeroMassimoPartecipanti = :numeroMassimoPartecipanti", Evento.class)
                .setParameter("numeroMassimoPartecipanti", numeroMassimoPartecipanti)
                .getResultList();
    }

    public List<Partecipazione> PartecipazioneDaConfermarePerEvento(Evento evento) {
        return em.createQuery("SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.stato = 'DA_CONFERMARE'", Partecipazione.class)
                .setParameter("evento", evento)
                .getResultList();
    }

}