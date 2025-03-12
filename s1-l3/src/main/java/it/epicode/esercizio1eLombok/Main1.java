package it.epicode.esercizio1eLombok;

public class Main1 {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(10,5);
        Rettangolo rettangolo2 = new Rettangolo(20,15);
        StampaDati.stampaRettangolo(rettangolo);
        StampaDati.stampaRettangolo(rettangolo2);
        StampaDati.stampaDueRettangoli(rettangolo,rettangolo2);
    }
}
