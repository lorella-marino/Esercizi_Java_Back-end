package it.epicode.s7_l1.dipendenti;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DipendenteRunner implements CommandLineRunner {
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Dipendente dipendente = new Dipendente();
            dipendente.setUsername(faker.name().username());
            dipendente.setNome(faker.name().firstName());
            dipendente.setCognome(faker.name().lastName());
            dipendente.setEmail(faker.internet().emailAddress());
            dipendente.setFotoProfilo(faker.internet().avatar());
            dipendenteRepository.save(dipendente);
        }
    }
}
