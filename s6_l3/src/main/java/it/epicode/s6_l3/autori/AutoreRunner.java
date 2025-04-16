package it.epicode.s6_l3.autori;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class AutoreRunner implements CommandLineRunner {
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Autore autore = new Autore();
            autore.setNome(faker.name().firstName());
            autore.setCognome(faker.name().lastName());
            autore.setEmail(faker.internet().emailAddress());
            autore.setDataDiNascita(faker.number() .numberBetween(1940, 2007));
            autore.setAvatar(faker.internet().avatar());
            autoreRepository.save(autore);
        }
    }
}
