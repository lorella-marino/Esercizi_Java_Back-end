package it.epicode.gestione_eventi_s3_l4.location;

import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

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

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }
}
