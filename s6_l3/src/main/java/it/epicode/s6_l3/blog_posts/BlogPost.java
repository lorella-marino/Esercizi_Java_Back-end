package it.epicode.s6_l3.blog_posts;

import it.epicode.s6_l3.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog_posts")

public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    @Column(length = 300)
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    private Autore autore;


}