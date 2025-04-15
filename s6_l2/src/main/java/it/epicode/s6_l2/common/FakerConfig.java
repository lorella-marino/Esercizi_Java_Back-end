package it.epicode.s6_l2.common;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfig {
    @Bean
    public Faker faker() {
        return new Faker(Locale.ITALIAN);
    }
}
