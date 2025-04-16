package it.epicode.s6_l3.blog_posts;

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