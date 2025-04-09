package it.epicode.s5_l3.menu;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class ProdottoMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private double price;
    private int calories;

    public String descrizione() {
        return name + " - " + price + "€" + " - " + calories + " kcal";
    }
}
