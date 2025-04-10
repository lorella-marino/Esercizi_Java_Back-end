package it.epicode.s5_l4.toppings;
import it.epicode.s5_l4.menu.ProdottoMenu;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Topping extends ProdottoMenu {
    public Topping(String nome, double prezzo, int calorie) {
        setName(nome);
        setPrice(prezzo);
        setCalories(calorie);
    }
}

