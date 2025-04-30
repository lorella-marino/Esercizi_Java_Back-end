package it.epicode.s7_l3.chain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ChainRunner implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
       System.out.println("---- Chain Runner ----");

       Generale generale = new Generale();
       generale.setNome("Generale");
       generale.setStipendio(5000);
       generale.setResponsabile(null);

       Colonnello colonnello = new Colonnello();
       colonnello.setNome("Colonnello");
       colonnello.setStipendio(4000);
       colonnello.setResponsabile(generale);

       Maggiore maggiore = new Maggiore();
       maggiore.setNome("Maggiore");
       maggiore.setStipendio(3000);
       maggiore.setResponsabile(colonnello);

       Capitano capitano = new Capitano();
       capitano.setNome("Capitano");
       capitano.setStipendio(2000);
       capitano.setResponsabile(maggiore);

        Tenente tenente = new Tenente();
        tenente.setNome("Tenente");
        tenente.setStipendio(1000);
        tenente.setResponsabile(capitano);

        int importo = 2000;
        System.out.println("Verifica importo: " + importo + "€");
        tenente.verificaImporto(importo);
        maggiore.verificaImporto(importo);
    }
}
