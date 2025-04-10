package it.epicode.s5_l4.tavoli;

import it.epicode.s5_l4.ordini.Ordine;
import it.epicode.s5_l4.tavoli.statoTavolo.StatoTavolo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tavoli")
public class Tavolo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private long numeroTavolo;
    private int numeroMaxCoperti;
    @Enumerated(EnumType.STRING)
    private StatoTavolo statoTavolo;

    public Tavolo(long numeroTavolo, int numeroMaxCoperti) {
        this.numeroTavolo = numeroTavolo;
        this.numeroMaxCoperti = numeroMaxCoperti;
        this.statoTavolo = StatoTavolo.LIBERO;
    }
}
