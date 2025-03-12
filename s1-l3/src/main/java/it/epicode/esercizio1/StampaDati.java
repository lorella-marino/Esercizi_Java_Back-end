package it.epicode.esercizio1;

// qui creiamo il codice per la stampa, ma la stampa vera e propria la facciamo nel Main
// solo per avere file più puliti

public class StampaDati {
    public static void stampaRettangolo(Rettangolo rettangolo) {
        System.out.println("Altezza: " + rettangolo.getAltezza());
        System.out.println("Larghezza: " + rettangolo.getLarghezza());
        System.out.println("Perimetro: " + rettangolo.perimetro());
        System.out.println("Area: " + rettangolo.area());
        System.out.println("");
    }

    public static void stampaDueRettangoli(Rettangolo rettangolo, Rettangolo rettangolo2) {
        System.out.println("---- Rettangolo 1 ----");
        System.out.println("Altezza: " + rettangolo.getAltezza());
        System.out.println("Larghezza: " + rettangolo.getLarghezza());
        System.out.println("Perimetro: " + rettangolo.perimetro());
        System.out.println("Area: " + rettangolo.area());
        System.out.println("");

        System.out.println("---- Rettangolo 2 ----");
        System.out.println("Altezza: " + rettangolo2.getAltezza());
        System.out.println("Larghezza: " + rettangolo2.getLarghezza());
        System.out.println("Perimetro: " + rettangolo2.perimetro());
        System.out.println("Area: " + rettangolo2.area());
        System.out.println("");

        System.out.println("---- Somme ----");
        System.out.println("Somma Area: " + rettangolo.area() + rettangolo2.area());
        System.out.println("Somma Perimetro: " + rettangolo.perimetro() + rettangolo2.perimetro());
    }

}
