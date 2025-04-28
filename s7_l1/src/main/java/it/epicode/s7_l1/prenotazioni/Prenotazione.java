package it.epicode.s7_l1.prenotazioni;

import it.epicode.s7_l1.dipendenti.Dipendente;
import it.epicode.s7_l1.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Viaggio viaggio;
    @ManyToOne
    private Dipendente dipendente;
    private String dataDiRichiesta;
    private String note;

}