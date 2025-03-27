package it.epicode.gestione_eventi_s3_l4.evento.gara;

import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import it.epicode.gestione_eventi_s3_l4.evento.TipoEvento;
import it.epicode.gestione_eventi_s3_l4.location.Location;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import it.epicode.gestione_eventi_s3_l4.persona.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
@NamedQuery (name = "GaraDiAtleticaPerVincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore")
@NamedQuery (name = "GaraDiAtleticaPerPartecipante", query = "SELECT g FROM GaraDiAtletica g WHERE g.setAtleti = :setAtleti")

public class GaraDiAtletica extends Evento {

    @ManyToMany
    private Set<Persona> setAtleti;

    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica(Long id, String titolo, LocalDate dataEvento, String descrizione, Location location, List<Partecipazione> partecipazione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Persona> setAtleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, location, partecipazione, tipoEvento, numeroMassimoPartecipanti);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }
}


