package it.epicode.s6_l2.blog_posts;

import com.github.javafaker.Faker;
import it.epicode.s6_l2.autori.Autore;
import it.epicode.s6_l2.autori.AutoreRepository;
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
        if(blogPostRepository.count() ==  0) {
            List<Autore> autori = autoreRepository.findAll();

        for (int i = 0; i < 10; i++) {
            BlogPost blogPost = new BlogPost();
            blogPost.setCategoria(faker.lorem().word());
            blogPost.setTitolo(faker.lorem().sentence());
            blogPost.setContenuto(faker.lorem().paragraph());
            blogPost.setTempoDiLettura(faker.number().numberBetween(1, 10));
            blogPost.setAutore(autori.get(i));
            blogPostRepository.save(blogPost);
        } }
    }
}
