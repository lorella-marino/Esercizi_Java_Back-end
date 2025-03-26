package it.epicode.gestione_eventi_s3_l3.evento;

import it.epicode.gestione_eventi_s3_l3.location.Location;
import it.epicode.gestione_eventi_s3_l3.partecipazione.Partecipazione;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "eventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (length = 100, nullable = false)
    private String titolo;

    @Column (nullable = false)
    private LocalDate dataEvento;

    @Column (length = 200, nullable = false)
    private String descrizione;

    @ManyToOne
    private Location location;

    @OneToMany (mappedBy = "evento")
    private List <Partecipazione> partecipazione = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column
    private int numeroMassimoPartecipanti;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, Location location, List <Partecipazione> partecipazione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.location = location;
        this.partecipazione = partecipazione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento(){}
}

// 1 evento many partecipazioni
// 1 evento 1 location

// many partecipazioni 1 evento
// many partecipazioni many persone

// 1 persona many partecipazioni
