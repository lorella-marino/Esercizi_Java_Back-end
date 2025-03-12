package it.epicode.esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    private int codiceCliente;
    private String nome;
    private String cognome;
    private String email;
    private double data;
}
