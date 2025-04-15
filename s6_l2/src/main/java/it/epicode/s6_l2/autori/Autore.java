package it.epicode.s6_l2.autori;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autori")

public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column( nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String cognome;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private Date dataDiNascita;
    private String avatar;


}