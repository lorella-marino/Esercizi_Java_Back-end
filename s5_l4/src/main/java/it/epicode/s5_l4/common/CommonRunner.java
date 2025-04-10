package it.epicode.s5_l4.common;

import it.epicode.s5_l4.bevande.BevandaService;
import it.epicode.s5_l4.menu.MenuService;
import it.epicode.s5_l4.ordini.OrdineRepository;
import it.epicode.s5_l4.ordini.OrdineService;
import it.epicode.s5_l4.pizze.PizzaRepository;
import it.epicode.s5_l4.pizze.PizzaService;
import it.epicode.s5_l4.tavoli.TavoloService;
import it.epicode.s5_l4.toppings.ToppingService;
import jakarta.transaction.Transactional;
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
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    @Value("${app.create.costoCoperto}")
    private double costoCoperto;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Creazione dati
        tavoloService.createTavolo();
        toppingService.createTopping();
        pizzaService.createPizza();
        bevandaService.createBevanda();
        menuService.createMenu();

        ordineService.createOrdine(costoCoperto);

        // query
        System.out.println(ordineRepository.findByNumeroOrdine(1));
        System.out.println(pizzaRepository.findById(14));

    }
}
