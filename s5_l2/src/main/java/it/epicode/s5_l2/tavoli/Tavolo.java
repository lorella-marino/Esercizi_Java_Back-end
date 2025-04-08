package it.epicode.s5_l2.tavoli;

import it.epicode.s5_l2.ordini.Ordine;
import it.epicode.s5_l2.tavoli.statoTavolo.StatoTavolo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tavolo {
    private long numeroTavolo;

    private int numeroMaxCoperti;

    private StatoTavolo statoTavolo = StatoTavolo.LIBERO;

    private Ordine ordine;

    public Tavolo(long numeroTavolo, int numeroMaxCoperti) {
        this.numeroTavolo = numeroTavolo;
        this.numeroMaxCoperti = numeroMaxCoperti;
    }
}
