package it.epicode.s6_l2.autori;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoreRunner implements CommandLineRunner {
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 20; i++) {
            Autore autore = new Autore();
            autore.setNome(faker.name().firstName());
            autore.setCognome(faker.name().lastName());
            autore.setEmail(faker.internet().emailAddress());
            autore.setDataDiNascita(faker.date().birthday());
            autore.setAvatar(faker.internet().avatar());
            autoreRepository.save(autore);
        }
    }
}
