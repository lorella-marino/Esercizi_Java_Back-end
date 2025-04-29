package it.epicode.s7_l2.dipendenti;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteRequest {
    private String nome;
    private String cognome;
    private String email;
}
