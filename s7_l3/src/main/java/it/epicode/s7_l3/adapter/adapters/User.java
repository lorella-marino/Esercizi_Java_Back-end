package it.epicode.s7_l3.adapter.adapters;

import it.epicode.s7_l3.adapter.DataSource;
import it.epicode.s7_l3.adapter.Info;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User implements DataSource {
    private Info info;

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }
    @Override
    public int getEta() {
        return LocalDate.now().getYear() - info.getDataDiNascita().getYear();
    }

}
