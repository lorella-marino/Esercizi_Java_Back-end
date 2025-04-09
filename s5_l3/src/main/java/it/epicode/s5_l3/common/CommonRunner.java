package it.epicode.s5_l3.common;

import it.epicode.s5_l3.bevande.BevandaService;
import it.epicode.s5_l3.menu.MenuService;
import it.epicode.s5_l3.ordini.OrdineService;
import it.epicode.s5_l3.pizze.PizzaService;
import it.epicode.s5_l3.tavoli.TavoloService;
import it.epicode.s5_l3.toppings.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommonRunner implements CommandLineRunner {
    @Autowired
    private TavoloService tavoloService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BevandaService bevandaService;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private OrdineService ordineService;

    @Value("${app.create.costoCoperto}")
    private double costoCoperto;

    @Override
    public void run(String... args) throws Exception {
        // Creazione dati
        tavoloService.createTavolo();
        toppingService.createTopping();
        pizzaService.createPizza();
        bevandaService.createBevanda();
        menuService.createMenu();


        ordineService.createOrdine(costoCoperto);
        ordineService.findAll().forEach(ordine -> System.out.println("Totale ordine: " + ordine.importoTotale(costoCoperto) + "€"));
    }
}
