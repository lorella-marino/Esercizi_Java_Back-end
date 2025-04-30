package it.epicode.s7_l3.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SottoSezione {
    private List<Pagina> pagine ;
}
