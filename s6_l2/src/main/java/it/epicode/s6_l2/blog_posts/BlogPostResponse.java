package it.epicode.s6_l2.blog_posts;

import it.epicode.s6_l2.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostResponse {
   private Long id;
   private String categoria;
   private String titolo;
   private String autore;

}