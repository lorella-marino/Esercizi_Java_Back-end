package it.epicode.s7_l1.viaggi;


import it.epicode.s7_l1.viaggi.stato.Stato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viaggi")

public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column (nullable = false, length = 50)
    private String destinazione;
    @Column (nullable = false)
    private String data;
    @Enumerated(EnumType.STRING)
    private Stato stato = Stato.IN_PROGRAMMA ;

}