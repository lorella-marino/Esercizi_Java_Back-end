package it.epicode.esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Carrello {

    private Cliente cliente1 = new Cliente(123, "Mario", "Rossi", "mariorossi@gmail",02.12);
    private Articolo[] articoli = new Articolo[2];
}
