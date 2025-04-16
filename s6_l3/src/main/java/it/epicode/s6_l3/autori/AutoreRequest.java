package it.epicode.s6_l3.autori;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {
    @NotBlank ( message = "Il campo NOME non può essere vuoto")
    private String nome;
    @NotBlank ( message = "Il campo COGNOME non può essere vuoto")
    private String cognome;
    @NotBlank ( message = "Il campo EMAIL non può essere vuoto")
    private String email;
    @Max( value = 2007 , message = "L'autore deve essere maggiorenne")
    private int dataDiNascita;
    private String avatar;
}
