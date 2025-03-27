package it.epicode.gestione_eventi_s3_l4.persona;

import it.epicode.gestione_eventi_s3_l4.evento.gara.GaraDiAtletica;
import it.epicode.gestione_eventi_s3_l4.partecipazione.Partecipazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

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

    @OneToMany (mappedBy = "vincitore")
    private List <GaraDiAtletica>  gareDiAtleticaVinte = new ArrayList<>();

    @ManyToMany (mappedBy = "setAtleti")
    private List <GaraDiAtletica> gareDiAtleticaPartecipate = new ArrayList<>();

    public Persona(Long id, String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso, List<Partecipazione> partecipazioni, List<GaraDiAtletica> gareDiAtleticaVinte, List<GaraDiAtletica> gareDiAtleticaPartecipate) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
        this.partecipazioni = partecipazioni;
        this.gareDiAtleticaVinte = gareDiAtleticaVinte;
        this.gareDiAtleticaPartecipate = gareDiAtleticaPartecipate;
    }
}
