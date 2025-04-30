package it.epicode.s7_l3.composite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class CompositeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---- Composite Runner ----");

        Pagina pagina1 = new Pagina("Capitolo 1");
        Pagina pagina2 = new Pagina("Capitolo 2");
        Pagina pagina3 = new Pagina("Capitolo 3");
        Pagina pagina4 = new Pagina("Capitolo 4");
        Pagina pagina5 = new Pagina("Capitolo 5");
        Pagina pagina6 = new Pagina("Capitolo 6");
        Pagina pagina7 = new Pagina("Capitolo 7");

        SottoSezione sottoSezione1 = new SottoSezione(List.of(pagina1, pagina2));
        SottoSezione sottoSezione2 = new SottoSezione(List.of(pagina3, pagina4, pagina5));
        SottoSezione sottoSezione3 = new SottoSezione(List.of(pagina6, pagina7));

        Sezione sezione1 = new Sezione(List.of(sottoSezione1, sottoSezione2));
        Sezione sezione2 = new Sezione(List.of(sottoSezione3));

        Libro libro = new Libro("Il Signore degli Anelli", List.of("J.R.R. Tolkien", "secondo autore"),List.of(sezione1, sezione2), 20.0);


        System.out.println("➡️ Libro:");
        libro.print();
        System.out.println("Numero di pagine del libro: " + libro.getTotPagine());

        System.out.println("➡️ Pagina 1:");
        pagina1.print();
        System.out.println("➡️ Sezione 1:");
        sezione1.print();



    }

}
