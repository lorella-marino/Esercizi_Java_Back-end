package it.epicode.esercio3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Scrivi una stringa e :q per terminare");
            String stringa = scanner.next();

            if (stringa.equals(":q")) break;

            String risultatoStringa = String.join(",", stringa.split(""));

            System.out.println(risultatoStringa);
        }
    }
}
