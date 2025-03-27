package it.epicode.gestione_eventi_s3_l4.evento;

import it.epicode.gestione_eventi_s3_l4.location.Location;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table (name = "eventi")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery( name = "EventiSoldOut" , query = "SELECT e FROM Evento e WHERE e.numeroMassimoPartecipanti = numeroMassimoPartecipanti")
@NamedQuery( name = "PartecipazioneDaConfermarePerEvento", query = "SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.stato = 'DA_CONFERMARE'")
public abstract class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String titolo;

    @Column(nullable = false)
    private LocalDate dataEvento;

    @Column(length = 200, nullable = false)
    private String descrizione;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazione = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column
    private int numeroMassimoPartecipanti;

    public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, Location location, List<Partecipazione> partecipazione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.location = location;
        this.partecipazione = partecipazione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

}

