package it.epicode.esercizio1;

import java.util.Scanner;

public class Main1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Esercizio 1 - 1
            System.out.println("---Esercizio 1-1---");

            System.out.println("Inserisci il primo numero");
            int n1 = scanner.nextInt();
            System.out.println("Inserisci il secondo numero");
            int n2 = scanner.nextInt();

            System.out.println(n1+" moltiplicato per "+n2+ " fa: "+ n1*n2);

            System.out.println(); // spazio in console

            // Esercizio 1 - 2
            System.out.println("---Esercizio 1-2---");

            System.out.println("Inserisci una frase");
            String frase = scanner.next();
            System.out.println("Inserisci un numero");
            int numero = scanner.nextInt();

            System.out.println(frase + " " + numero);

            System.out.println(); // spazio in console

            // Esercizio 1 - 3
            System.out.println("---Esercizio 1-3---");

            String[] array = new String[6];
            System.out.println("Inserisci 6 parole");
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.next();
            }
            System.out.println(array[0] + " " + array[1] + " " + array[5] + " " + array[2] + " " + array[3] + " " + array[4]);


    }
}
