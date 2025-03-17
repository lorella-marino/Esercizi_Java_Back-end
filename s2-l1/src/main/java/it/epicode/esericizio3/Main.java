package it.epicode.esericizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContoCorrente conto1 = new ContoCorrente("Luca", 20000.0);
        ContoOnLine conto2 = new ContoOnLine("Mario", 1000.0, 1500);

        while (true) {
            try {
                System.out.println("Effettua un prelievo per Luca (ContoCorrente):");
                double importo1 = scanner.nextDouble();
                conto1.preleva(importo1);
                logger.info("Prelievo effettuato con successo per Luca!");

                System.out.println("Effettua un prelievo per Mario (ContoOnLine):");
                double importo2 = scanner.nextDouble();
                conto2.preleva(importo2);
                logger.info("Prelievo effettuato con successo per Mario!");
            } catch (BancaException e) {
                logger.error("Errore: " + e.getMessage());
            }

            System.out.println("Saldo aggiornato:");
            System.out.println("Luca (ContoCorrente): " + conto1.restituisciSaldo());
            conto2.stampaSaldo();

            System.out.println("Vuoi continuare a prelevare? (s/n)");
            String risposta = scanner.next();
            if (risposta.equalsIgnoreCase("n")) {
                break;
            }
        }

    }
}
