package it.epicode.s5_l3.toppings;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ToppingService {
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private Faker faker;

    public void createTopping() {
        for (int i = 0; i < 10; i++) {
            Topping topping = new Topping();
            topping.setName(faker.food().ingredient());
            topping.setPrice(faker.number().randomDouble(2, 1, 20));
            topping.setCalories(faker.number().numberBetween(10, 100));
            toppingRepository.save(topping);
        }
    }

    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

}
