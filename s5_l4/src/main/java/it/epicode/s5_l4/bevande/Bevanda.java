package it.epicode.s5_l4.bevande;

import it.epicode.s5_l4.menu.ProdottoMenu;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Bevanda extends ProdottoMenu {
    private double litri;

    public Bevanda(String name, double price, int calories, double litri) {
        setName(name);
        setPrice(price);
        setCalories(calories);
        setLitri(litri);
    }
}