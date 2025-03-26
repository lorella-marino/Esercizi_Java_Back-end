package it.epicode.gestione_eventi.eventi;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table (name = "evento")
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

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column
    private int numeroMassimoPartecipanti;

    public Evento( String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento getEvento() {
        return this;
    }
}
