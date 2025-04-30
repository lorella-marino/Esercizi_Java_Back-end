package it.epicode.s7_l3.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sezione implements VociDelLibro {
    private List<SottoSezione> sottoSezioni;

    @Override
    public int getTotPagine() {
        return sottoSezioni.stream().mapToInt(sottoSezione -> sottoSezione.getPagine().size()).sum();
    }

    public void print() {
        System.out.println("SottoSezioni: " + sottoSezioni);
    }
}
