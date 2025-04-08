package it.epicode.s5_l2.bevande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BevandaConfig {
    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua", 0.5, 0.0, 0);
    }

    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", 0.5, 2.0, 150);
    }

    @Bean
    public Bevanda fanta() {
        return new Bevanda("Fanta", 0.5, 2.0, 150);
    }

    @Bean
    public Bevanda sprite() {
        return new Bevanda("Sprite", 0.5, 2.0, 150);
    }
}
