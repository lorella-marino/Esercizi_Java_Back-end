package it.epicode.s5_l1.menu;

import it.epicode.s5_l1.bevande.Bevanda;
import it.epicode.s5_l1.pizze.Pizza;
import it.epicode.s5_l1.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuRunner implements CommandLineRunner {
    private final Menu menu;

    @Override
    public void run(String... args) throws Exception {
        menu.printMenu();

    }
}
