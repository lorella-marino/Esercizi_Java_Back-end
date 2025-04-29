package it.epicode.s7_l2.viaggi;

import com.github.javafaker.Faker;
import it.epicode.s7_l2.viaggi.stato.Stato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ViaggioRunner implements CommandLineRunner{
    @Autowired
    private ViaggioRepository viaggioRepository;
    @Autowired
    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
            for (int i = 0; i < 10; i++) {
                Viaggio viaggio = new Viaggio();
                viaggio.setDestinazione(faker.address().city());
                viaggio.setData(String.valueOf(faker.date().between(faker.date().past(365, java.util.concurrent.TimeUnit.DAYS), faker.date().future(365, java.util.concurrent.TimeUnit.DAYS))));
                viaggio.setStato(Stato.IN_PROGRAMMA);
                viaggioRepository.save(viaggio);
            }
    }
}
