package it.epicode.esercizio2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Esercizio 2 - 1
        System.out.println("---Esercizio 2-1---");

        String[] array = new String[3];
        System.out.println("Inserisci 3 parole");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }
        System.out.println(array[0] + " " + array[1] + " " + array[2] );
        System.out.println(array[2] + " " + array[1] + " " + array[0]);

    }
}
