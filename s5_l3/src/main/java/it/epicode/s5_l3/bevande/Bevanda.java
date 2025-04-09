package it.epicode.s5_l3.bevande;

import it.epicode.s5_l3.menu.ProdottoMenu;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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