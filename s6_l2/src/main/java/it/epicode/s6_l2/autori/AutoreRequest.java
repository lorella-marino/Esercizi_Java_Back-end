package it.epicode.s6_l2.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {
    private String nome;
    private String cognome;
    private String email;
    private Date dataDiNascita;
    private String avatar;
}
