package it.epicode.s7_l3.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements VociDelLibro{
    private String titolo;
    private List<String> autori;
    private List<Sezione> sezioni;
    private double prezzo;

    @Override
    public int getTotPagine() {
        return sezioni.stream().mapToInt(Sezione::getTotPagine).sum();
    }

    public void print() {
        System.out.println("Titolo: " + titolo);
        System.out.println("Autori: " + autori);
        System.out.println("Sezioni: " + sezioni);
        System.out.println("Prezzo: " + prezzo);
    }
}
