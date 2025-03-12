package it.epicode.esercizio3;

public class Main3 {
    public static void main(String[] args) {
        Carrello carrello = new Carrello();

        Articolo articolo1 = new Articolo(927289, "IPhone", 850.20, 10);
        carrello.getArticoli()[0] = articolo1;
        Articolo articolo2 = new Articolo(122829, "Ipad", 450.00, 25);
        carrello.getArticoli()[1] = articolo2;
        System.out.println(carrello);

        double sommaPrezzo = articolo1.getPrezzo() + articolo2.getPrezzo();
        System.out.println("Costo totale: "+ sommaPrezzo);



    }
}
