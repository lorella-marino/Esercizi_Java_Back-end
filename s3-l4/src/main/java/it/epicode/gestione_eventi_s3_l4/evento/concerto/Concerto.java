package it.epicode.gestione_eventi_s3_l4.evento.concerto;

import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import it.epicode.gestione_eventi_s3_l4.evento.TipoEvento;
import it.epicode.gestione_eventi_s3_l4.location.Location;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@NamedQuery (name = "ConcertoInStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming")
@NamedQuery (name = "ConcertoPerGenere", query = "SELECT c FROM Concerto c WHERE c.genere = :genere")

public class Concerto extends Evento {

    @Enumerated (EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    public Concerto(Long id, String titolo, LocalDate dataEvento, String descrizione, Location location, List<Partecipazione> partecipazione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Genere genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, location, partecipazione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}
