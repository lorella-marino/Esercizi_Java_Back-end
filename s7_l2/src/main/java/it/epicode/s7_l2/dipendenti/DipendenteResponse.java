package it.epicode.s7_l2.dipendenti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteResponse {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String fotoProfilo;
}
