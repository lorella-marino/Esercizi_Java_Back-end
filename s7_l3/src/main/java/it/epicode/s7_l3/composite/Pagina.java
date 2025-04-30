package it.epicode.s7_l3.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagina {
    private String titoloPagina;

    public void print () {
        System.out.println(titoloPagina);
    }
}
