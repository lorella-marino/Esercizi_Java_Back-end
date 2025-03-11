package it.epicode.esercio2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scrivi un numero");

        int numero = scanner.nextInt();

        String lett = "";

        switch (numero){
            case 0: lett = "zero";
                break;
            case 1: lett = "uno";
                break;
            case 2: lett = "due";
                break;
            case 3: lett = "tre";
                break;
            default: lett = "Numero inserito non valido";
                break;
        }
        System.out.println(lett);
    }
}
