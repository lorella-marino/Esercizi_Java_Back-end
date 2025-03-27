package it.epicode.gestione_eventi_s3_l4.evento.partita;

import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import it.epicode.gestione_eventi_s3_l4.evento.TipoEvento;
import it.epicode.gestione_eventi_s3_l4.location.Location;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@NamedQuery (name = "PartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraDiCasa = :squadraDiCasa")
@NamedQuery (name = "PartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = :squadraOspite")
@NamedQuery (name = "PartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = null")

public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golSquadraDiCasa;
    private int golSquadraOspite;


    public PartitaDiCalcio(Long id, String titolo, LocalDate dataEvento, String descrizione, Location location, List<Partecipazione> partecipazione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(id, titolo, dataEvento, descrizione, location, partecipazione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraDiCasa = golSquadraDiCasa;
        this.golSquadraOspite = golSquadraOspite;
    }
}
