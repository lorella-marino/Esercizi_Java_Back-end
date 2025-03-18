package it.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero");
        int numero = scanner.nextInt();

        System.out.println("Lista: ");

        // numeri random
        List <Integer> lista = new ArrayList<>(numero);

        for (int i = 0; i < numero; i++) {
            lista.add((int) (Math.random() * 101));
            System.out.print(lista.get(i) + " ");
        }

        System.out.println(" ");
        System.out.println("Lista inversa: ");

        // lista inversa
        List<Integer> listaInversa = new ArrayList<>(lista);
        for (int i = 0; i < lista.size(); i++) {
            listaInversa.add(i, lista.get(lista.size() - 1 - i));
            System.out.print(lista.get(i) + " " + listaInversa.get(i) + " ");
        }

        // pari o dispari
        List <Integer> pari = new ArrayList<>();
        List <Integer> dispari = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                pari.add(lista.get(i));
            } else {
                dispari.add(lista.get(i));
            }
        }

        System.out.println(" ");
        System.out.println("Lista pari: " + pari);
        System.out.println("Lista dispari: " + dispari);

    }
}
