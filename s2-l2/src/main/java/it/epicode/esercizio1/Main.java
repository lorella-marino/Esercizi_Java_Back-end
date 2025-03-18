package it.epicode.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero degli elementi");
        int numero = scanner.nextInt();

        Set<String> paroleDuplicate = new HashSet<>();
        Set<String> paroleUniche = new HashSet<>();

        for (int i = 0; i < numero; i++) {
            System.out.println("Inserisci la parola");
            String parola = scanner.next();
            if (!paroleUniche.add(parola)) { // se la parola è già in paroleUniche
                paroleDuplicate.add(parola); // la mette nelle paroleDuplicate
                // perché il Set non accetta duplicati, quindi lo passa all'altro Set
            }
        }
        System.out.println("Parole duplicate: " + paroleDuplicate);
        System.out.println("Numero parole distinte: " + paroleUniche.size());
        System.out.println("Elenco parole distinte: " + paroleUniche);
    }
}
