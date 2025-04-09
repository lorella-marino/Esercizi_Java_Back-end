package it.epicode.s5_l3.ordini;

import it.epicode.s5_l3.menu.ProdottoMenu;
import it.epicode.s5_l3.ordini.statoOrdine.StatoOrdine;
import it.epicode.s5_l3.tavoli.Tavolo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroOrdine;

    @OneToMany (fetch = FetchType.EAGER)
    private List<ProdottoMenu> prodottiMenu = new ArrayList<>();

    @ManyToOne
    private Tavolo tavolo;

    private StatoOrdine statoOrdine;

    private int numeroCoperti;

    private LocalTime orarioAcquisizione;

    public double importoTotale(double costoCoperto) {
        double totale = numeroCoperti * costoCoperto;
        for (ProdottoMenu prodotto : prodottiMenu) {
            totale += prodotto.getPrice();
        }
        return totale;
    }

    public void printOrdine(double costoCoperto) {
        System.out.println("Numero ordine: " + numeroOrdine);
        System.out.println("Stato ordine: " + statoOrdine);
        System.out.println("Numero coperti: " + numeroCoperti);
        System.out.println("Orario: " + orarioAcquisizione);
        System.out.println("Prodotti ordinati:");
        for (ProdottoMenu prodotto : prodottiMenu) {
            System.out.println("- " + prodotto.getName() + " (" + prodotto.getPrice() + "€)");
        }
        System.out.println("Importo totale: " + importoTotale(costoCoperto) + "€");
    }
}
