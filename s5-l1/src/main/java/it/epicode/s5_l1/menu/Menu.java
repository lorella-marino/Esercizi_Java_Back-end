package it.epicode.s5_l1.menu;

import it.epicode.s5_l1.bevande.Bevanda;
import it.epicode.s5_l1.pizze.Pizza;
import it.epicode.s5_l1.toppings.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String name;
    private List<Pizza> pizze = new ArrayList<>();
    private List<Bevanda> bevande = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();

    public void printMenu() {
        System.out.println("-- Menu " + name + " --");
        System.out.println("--- pizze ---");
        for (Pizza pizza : pizze) {
            System.out.println(pizza.descrizioneRiga());
        }

        System.out.println("--- bevande ---");
        for (Bevanda bevanda : bevande) {
            System.out.println(bevanda.descrizioneRiga());
        }

        System.out.println("--- toppings ---");
        for (Topping topping : toppings) {
            System.out.println(topping.descrizioneRiga());
        }}
}

