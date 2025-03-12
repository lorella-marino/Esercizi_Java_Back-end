package it.epicode.esercizio1;

public class Rettangolo {
    private double altezza;
    private double larghezza;

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public Rettangolo (double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public Rettangolo(){} //per poterne fare uno libero

    public double area() {
        return altezza * larghezza;
    }

    public double perimetro() {
        return 2 * (altezza + larghezza);
    }


}