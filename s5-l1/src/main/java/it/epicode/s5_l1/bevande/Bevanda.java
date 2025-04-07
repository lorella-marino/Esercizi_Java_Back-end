package it.epicode.s5_l1.bevande;

import it.epicode.s5_l1.menu.RigaMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bevanda implements RigaMenu {
    private String name;
    private double litri;
    private double price;
    private double calories;

    @Override
    public String descrizioneRiga() {
        return name + " - " + litri + "l" + " - " +price + "€" + " - " + calories + " kcal";
    }

}