package it.epicode.s5_l3.menu;

import it.epicode.s5_l3.bevande.BevandaService;
import it.epicode.s5_l3.pizze.PizzaService;
import it.epicode.s5_l3.toppings.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BevandaService bevandaService;
    @Autowired
    private ToppingService toppingService;

    public void createMenu() {
        Set<ProdottoMenu> prodottiMenu = new HashSet<>();
        prodottiMenu.addAll(pizzaService.findAll());
        prodottiMenu.addAll(bevandaService.findAll());
        prodottiMenu.addAll(toppingService.findAll());

        Menu menu = new Menu();
        menu.setName("Menu Pizzeria");
        menu.setProdottiMenu(prodottiMenu);
        menuRepository.save(menu);
    }

    public Menu getMenu() {
        return menuRepository.findAll().get(0);
    }
}
