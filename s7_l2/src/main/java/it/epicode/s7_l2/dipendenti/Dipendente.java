package it.epicode.s7_l2.dipendenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dipendenti")

public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column (nullable = false, length = 20)
    private String username;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false)
    private String cognome;
    @Column (nullable = false)
    private String email;
    private String fotoProfilo;

}