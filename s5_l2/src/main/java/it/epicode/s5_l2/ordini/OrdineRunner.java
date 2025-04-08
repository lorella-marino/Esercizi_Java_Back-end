package it.epicode.s5_l2.ordini;

import it.epicode.s5_l2.menu.Menu;
import it.epicode.s5_l2.ordini.statoOrdine.StatoOrdine;
import it.epicode.s5_l2.tavoli.Tavolo;
import it.epicode.s5_l2.tavoli.statoTavolo.StatoTavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class OrdineRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;
    @Value( "${app.create.costoCoperto}" )
    private double costoCoperto;

    @Override
    public void run(String ...args ) throws Exception {
        System.out.println("Costo coperto: " + costoCoperto);
        Tavolo tavolo = new Tavolo(1, 4);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine();
        ordine.setNumeroOrdine(1);
        ordine.setNumeroCoperti(4);
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOrarioAcquisizione(LocalTime.now());
        ordine.setProdotti( List.of(
                menu.getPizze().get(0),
                menu.getPizze().get(1),
                menu.getBevande().get(0),
                menu.getBevande().get(1),
                menu.getToppings().get(2)));

        ordine.setTavolo(tavolo);
        ordine.printOrdine(costoCoperto);


    }
}
