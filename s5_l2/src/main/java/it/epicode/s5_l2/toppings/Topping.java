package it.epicode.s5_l2.toppings;
import it.epicode.s5_l2.menu.RigaMenu;
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

    @Override
    public double getPrezzo() {
        return price;
    }
}
