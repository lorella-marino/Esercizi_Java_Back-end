package it.epicode.s7_l3.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Ufficiale {
    private String nome;
    private int stipendio;
    private Ufficiale responsabile;

    public void verificaImporto (int importo) {
        if (importo > stipendio) {
            System.out.println("Il " + nome + " non ha tale importo");
        } else {
            System.out.println("Il " + nome + " ha tale importo");
        }
    }
}
