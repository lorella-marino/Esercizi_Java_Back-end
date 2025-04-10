package it.epicode.s5_l4.bevande;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BevandaService {
    @Autowired
    private BevandaRepository bevandaRepository;
    @Autowired
    private Faker faker;

    public void createBevanda() {
        for (int i = 0; i < 10; i++) {
            Bevanda bevanda = new Bevanda();
            bevanda.setName(faker.food().ingredient());
            bevanda.setPrice(faker.number().randomDouble(2, 1, 20));
            bevanda.setCalories(faker.number().numberBetween(100, 2000));
            bevandaRepository.save(bevanda);
        }
    }

    public List<Bevanda> findAll() {
        return bevandaRepository.findAll();
    }
}
