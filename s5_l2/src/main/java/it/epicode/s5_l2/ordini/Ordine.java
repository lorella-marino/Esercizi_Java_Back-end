package it.epicode.s5_l2.ordini;

import it.epicode.s5_l2.menu.Menu;
import it.epicode.s5_l2.menu.RigaMenu;
import it.epicode.s5_l2.ordini.statoOrdine.StatoOrdine;
import it.epicode.s5_l2.tavoli.Tavolo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {
    private long numeroOrdine ;

    private List <RigaMenu> prodotti;

    private Tavolo tavolo;

    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private LocalTime orarioAcquisizione;

    private double importoTotale(double costoUnitarioCoperto){
        double prezzoTotale = 0;
        for (RigaMenu prodotto : prodotti) {
            prezzoTotale += prodotto.getPrezzo();
        }
        prezzoTotale += costoUnitarioCoperto * numeroCoperti;

        return prezzoTotale;
    }


    public void printOrdine(double costoUnitarioCoperto ){
        System.out.println("Numero ordine: " + numeroOrdine);
        System.out.println("Stato ordine: " + statoOrdine);
        System.out.println("Numero coperti: " + numeroCoperti);
        System.out.println("Orario acquisizione: " + orarioAcquisizione);
        System.out.println("Numero tavolo: " + tavolo.getNumeroTavolo());
        System.out.println("Prodotti: ");
        for (RigaMenu prodotto : prodotti) {
            System.out.println(prodotto.descrizioneRiga());
        }
        System.out.println("Importo totale: " + importoTotale(costoUnitarioCoperto));
    }
}
