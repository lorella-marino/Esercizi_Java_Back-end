package it.epicode.gestione_eventi_s3_l3.location;

import it.epicode.gestione_eventi_s3_l3.evento.Evento;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table (name = "locations")
public class Location {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (length = 100, nullable = false)
    private String nome;

    @Column (length = 100, nullable = false)
    private String citta;

    @OneToMany (mappedBy = "location")
    private List <Evento> eventi = new ArrayList<>();

    public Location(String nome, String citta, List<Evento> eventi) {
        this.nome = nome;
        this.citta = citta;
        this.eventi = eventi;
    }
}
