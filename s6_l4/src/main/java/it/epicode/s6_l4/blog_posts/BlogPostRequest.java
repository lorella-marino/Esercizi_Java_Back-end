package it.epicode.s6_l4.blog_posts;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostRequest {
    @NotBlank ( message = "Il campo TITOLO non può essere vuoto")
    private String titolo;
    @NotBlank ( message = "Il campo CONTENUTO non può essere vuoto")
    private String contenuto;
    @Max( value = 15, message = "Il tempo di lettura non può superare i 15 minuti")
    private int tempoDiLettura;
    @NotBlank ( message = "Il campo AUTORE non può essere vuoto")
    private Long autoreId;
    private String categoria;
    private String cover;
}
