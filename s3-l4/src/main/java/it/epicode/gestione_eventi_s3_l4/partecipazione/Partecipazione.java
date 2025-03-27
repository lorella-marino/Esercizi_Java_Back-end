package it.epicode.gestione_eventi_s3_l4.partecipazione;

import it.epicode.gestione_eventi_s3_l4.evento.Evento;
import it.epicode.gestione_eventi_s3_l4.persona.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table (name = "partecipazioni")

public class Partecipazione {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Enumerated (EnumType.STRING)
    private Stato stato;

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }
}
