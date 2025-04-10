package it.epicode.s5_l4.menu;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @OneToMany
    private Set<ProdottoMenu> prodottiMenu = new HashSet<>();
}


