package it.epicode.esercizio2;

public class Main2 {
    public static void main(String[] args) {
        Chiamata[] chiamate = new Chiamata[5];

        Sim sim = new Sim("311311311",0,chiamate);
        System.out.println(sim);

        Chiamata c1 = new Chiamata(12,"333444555");
        sim.getChiamate()[0] = c1;
        Sim sim2 = new Sim("211211211",2,chiamate);
        System.out.println(sim2);
    }
}
