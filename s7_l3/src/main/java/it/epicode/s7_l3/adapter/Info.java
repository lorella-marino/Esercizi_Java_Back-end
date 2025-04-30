package it.epicode.s7_l3.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
}
