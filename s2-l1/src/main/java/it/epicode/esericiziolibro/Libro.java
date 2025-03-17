package it.epicode.esericiziolibro;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Data
public class Libro {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private String titolo;
    private int anno;
    private String autore;
    private String genere;
    private String casaEditrice;
    private boolean prestato;

    public Libro(String titolo, int anno, String autore, String genere, String casaEditrice) {
        this.titolo = titolo;
        this.anno = anno;
        this.autore = autore;
        this.genere = genere;
        this.casaEditrice = casaEditrice;
        this.prestato = false;
    }

    public void presta() throws LibroGiaPrestatoException {
        if (this.prestato) {
            throw new LibroGiaPrestatoException( "Il libro " + titolo + " è stato già prestato");
        }
        this.prestato = true;
        logger.info("Il libro " + titolo + " è stato prestato con successo");
    }

}
