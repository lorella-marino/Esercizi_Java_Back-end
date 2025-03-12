package it.epicode.esercizio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sim {
    private String nTelefono;
    private double credito;
    private Chiamata[] chiamate = new Chiamata[5];
}
