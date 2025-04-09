package it.epicode.s5_l3.tavoli;

import com.github.javafaker.Faker;
import it.epicode.s5_l3.tavoli.statoTavolo.StatoTavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TavoloService {
    @Autowired
    private TavoloRepository tavoloRepository;
    @Autowired
    private Faker faker;

    public void createTavolo() {
        for (int i = 0; i < 10; i++) {
            Tavolo tavolo = new Tavolo();
            tavolo.setNumeroTavolo(faker.number().numberBetween(1, 10));
            tavolo.setNumeroMaxCoperti(faker.number().numberBetween(1, 10));
            tavolo.setStatoTavolo(StatoTavolo.LIBERO);
            tavoloRepository.save(tavolo);
        }
    }

    public List<Tavolo> findAll() {
        return tavoloRepository.findAll();
    }
}
