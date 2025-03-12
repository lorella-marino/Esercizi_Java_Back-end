package it.epicode.esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Articolo {
    private int codiceArticolo;
    private String descrizione;
    private double prezzo;
    private int pezziDisponibili;
}
