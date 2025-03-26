package it.epicode.gestione_eventi_s3_l3.persona;

import it.epicode.gestione_eventi_s3_l3.partecipazione.Partecipazione;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "persone")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (length = 50, nullable = false)
    private String nome;

    @Column (length = 50, nullable = false)
    private String cognome;

    @Column (length = 50)
    private String email;

    @Column (length = 50)
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany (mappedBy = "persona")
    private List <Partecipazione> partecipazioni = new ArrayList<>();

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso, List<Partecipazione> partecipazioni) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
        this.partecipazioni = partecipazioni;
    }
}
