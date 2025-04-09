package it.epicode.s5_l3.pizze;

import it.epicode.s5_l3.menu.ProdottoMenu;
import it.epicode.s5_l3.toppings.Topping;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Pizza extends ProdottoMenu {
    @ManyToMany
    private List<Topping> toppings = new ArrayList<>();

    @Override
    public double getPrice() {
        double totalPrice = super.getPrice();
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    @Override
    public int getCalories() {
        int totalCalories = super.getCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.getCalories();
        }
        return totalCalories;
    }
}
