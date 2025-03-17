package it.epicode.esericiziolibro;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
        private static final Logger logger = LoggerFactory.getLogger(Main.class);

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libro[] biblioteca = {
                new Libro("Il Signore degli Anelli", 1954, "J.R.R. Tolkien", "Fantasy", "Casa Editrice 1"),
                new Libro("1984", 1949, "George Orwell", "Dystopian", "Casa Editrice 2"),
                new Libro("Il Nome della Rosa", 1980, "Umberto Eco", "Thriller", "Casa Editrice 3")
        };

        while (true){
            logger.info("Scegli un libro, 0 per uscire");
            for (int i = 0; i < biblioteca.length; i++) {
                logger.info("{}. {}", i+1, biblioteca[i].getTitolo());
            }
            try{
                int scelta = scanner.nextInt();
                if (scelta == 0) break;
                biblioteca[scelta-1].presta();
            } catch (Exception e){
                logger.error("Errore durante la scelta del libro: " + e.getMessage());
            }
        }
    }
}
