package it.epicode.s5_l1.toppings;
import it.epicode.s5_l1.menu.RigaMenu;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements RigaMenu {
    private String name;
    private double price;
    private double calories;

    @Override
    public String descrizioneRiga() {
        return name + " - " + price + "€" + " - " + calories + " kcal";
    }
}
