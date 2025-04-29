package it.epicode.s7_l2.dipendenti;

import it.epicode.s7_l2.security.auth.app_user.AppUser;
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

    @OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST})
    private AppUser appUser;

    @Column (nullable = false)
    private String nome;
    @Column (nullable = false)
    private String cognome;
    @Column (nullable = false)
    private String email;
    private String fotoProfilo;

}