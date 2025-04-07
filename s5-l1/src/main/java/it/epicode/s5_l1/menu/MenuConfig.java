package it.epicode.s5_l1.menu;

import it.epicode.s5_l1.bevande.Bevanda;
import it.epicode.s5_l1.pizze.Pizza;
import it.epicode.s5_l1.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MenuConfig {

    private final Pizza salami;
    private final Pizza margherita;
    private final Pizza hawaiian;
    private final Pizza romana;

    private final Bevanda acqua;
    private final Bevanda cocaCola;
    private final Bevanda fanta;
    private final Bevanda sprite;

    private final Topping salame;
    private final Topping prosciutto;
    private final Topping ananas;
    private final Topping pomodoro;
    private final Topping mozzarella;

    @Bean
    public Menu menu() {
        return new Menu("Menu Pizzeria",
                List.of(salami, margherita, hawaiian, romana),
                List.of(acqua, cocaCola, fanta, sprite),
                List.of(salame, prosciutto, ananas, pomodoro, mozzarella));
    }
}
