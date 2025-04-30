package it.epicode.s7_l3.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData implements DataSource {
    private String nomeCompleto;
    private int eta;


    /* impostazione sbagliata dell'esercizio, abbiamo usato un altro metodo più giusto con StampaUtente
    public void getData(DataSource ds) {
        nomeCompleto = ds.getNomeCompleto();
        eta = ds.getEta();
    }*/
}
