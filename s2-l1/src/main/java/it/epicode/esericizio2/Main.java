package it.epicode.esericizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Numero di km percorsi:");
            int km = scanner.nextInt();
            System.out.println("Numero di litri di carburante consumati:");
            int litri = scanner.nextInt();

            if (litri == 0){
                logger.error("I litri non possono essere 0");
                return;
            }

            double consumo = km/litri;
            logger.info("Il consumo è di "+ consumo + " km/l");

        } catch (Exception e) {
            logger.error("Errore " + e.getMessage());
        }
    }
}
