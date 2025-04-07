package it.epicode.s5_l1.pizze;

import it.epicode.s5_l1.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PizzaConfig {
    private final Topping salame;
    private final Topping prosciutto;
    private final Topping ananas;
    private final Topping mozzarella;
    private final Topping pomodoro;

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", List.of(pomodoro, mozzarella), 4.0, 1000);
    }

    @Bean
    public Pizza salami() {
        return new Pizza("Salami Pizza", List.of(pomodoro, mozzarella, salame), 5.0, 1100);
    }

    @Bean
    public Pizza hawaiian() {
        return new Pizza("Hawaiian Pizza", List.of(pomodoro, mozzarella, prosciutto, ananas), 6.0, 1200);
    }

    @Bean
    public Pizza romana() {
        return new Pizza("Romana", List.of(pomodoro, mozzarella, prosciutto), 6.0, 1200);
    }


}
