package it.epicode.esercio1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scrivi una stringa");
        String stringaPariDispari = scanner.next();

        if (stringaPariDispari.length() %2 == 0){
            System.out.println(true);
        } else {System.out.println(false);}


        System.out.println("Scrivi un anno");
        int annoBisestile = scanner.nextInt();

        if (annoBisestile %4 == 0){
            System.out.println(true);
        } else if (annoBisestile %100 == 0 && annoBisestile %400 == 0){System.out.println(true);
        } else {System.out.println(false);}
    }
}
