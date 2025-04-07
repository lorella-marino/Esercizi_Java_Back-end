package it.epicode.s5_l1.toppings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {
    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.0, 50);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.0, 50);
    }

    @Bean
    public Topping salame() {
        return new Topping("Salame", 1.0, 50);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 1.0, 50);
    }

    @Bean
    public Topping pomodoro() {
        return new Topping("Pomodoro", 1.0, 50);
    }
}
