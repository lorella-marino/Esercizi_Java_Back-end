package it.epicode.esercizio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Chiamata {
    private double minuti;
    private String numeroChiamato;
}
