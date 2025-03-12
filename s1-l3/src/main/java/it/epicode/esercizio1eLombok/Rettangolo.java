package it.epicode.esercizio1eLombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rettangolo {
    private double altezza;
    private double larghezza;

    public double area() {
        return altezza * larghezza;
    }

    public double perimetro() {
        return 2 * (altezza + larghezza);
    }


}
