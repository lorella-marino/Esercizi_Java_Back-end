package it.epicode.esericizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //array di 5 numeri interi casuali
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
            System.out.println(array[i] + " ");
        }

        boolean richiedi =  true;

        while (richiedi){
            try {
                System.out.println("Inserisci un numero da 0 a 10");
                int numero = scanner.nextInt();
                System.out.println("Inserisci la posizione in cui vuoi inserire il numero, 0 per uscire");
                int posizione = scanner.nextInt();
                array[posizione-1] = numero;

                if(posizione==0){
                    richiedi = false;
                    break;
                }

                if (numero > 10 || numero < 0) {
                    logger.error("Il numero inserito non è valido");
                    continue;
                }

                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + " ");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error("Non hai inserito un valore corretto");
            }
        }



    }
}
