package it.epicode.s6_l4.blog_posts;

import com.github.javafaker.Faker;
import it.epicode.s6_l4.autori.Autore;
import it.epicode.s6_l4.autori.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogPostRunner implements CommandLineRunner {
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        List<Autore> autori = autoreRepository.findAll();

        if (!autori.isEmpty()) {
            for (int i = 0; i < 50; i++) {
                BlogPost blogPost = new BlogPost();
                blogPost.setCategoria(faker.lorem().word());
                blogPost.setTitolo(faker.lorem().sentence());
                blogPost.setContenuto(faker.lorem().paragraph());
                blogPost.setTempoDiLettura(faker.number().numberBetween(1, 15));
                blogPost.setAutore(autori.get(i % autori.size()));
                blogPostRepository.save(blogPost);
            }
    }
}
}
