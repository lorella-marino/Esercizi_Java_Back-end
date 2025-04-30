package it.epicode.s7_l3.adapter;

public class StampaUtente {
    public static void print(DataSource ds) {
        System.out.println("Nome Completo: " + ds.getNomeCompleto());
        System.out.println("Età: " + ds.getEta());
    }
}
