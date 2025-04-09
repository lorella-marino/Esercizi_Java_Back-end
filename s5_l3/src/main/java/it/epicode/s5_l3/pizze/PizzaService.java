package it.epicode.s5_l3.pizze;

import com.github.javafaker.Faker;
import it.epicode.s5_l3.toppings.Topping;
import it.epicode.s5_l3.toppings.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private Faker faker;

    public void createPizza() {
        for (int i = 0; i < 10; i++) {
            Pizza pizza = new Pizza();
            pizza.setName(faker.food().dish());
            pizza.setPrice(faker.number().randomDouble(2, 5, 20));
            pizza.setCalories(faker.number().numberBetween(100, 1000));
            pizza.setToppings(toppingService.findAll());
            pizzaRepository.save(pizza);
        }
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }
}

