package it.epicode.esericzio;

import lombok.Data;

@Data
public class Volontario implements CheckIn{
    private String nome;
    private int eta;
    private String cv;

    public Volontario(String nome, int eta, String cv) {
        this.nome = nome;
        this.eta = eta;
        this.cv = cv;
    }

    @Override
    public void checkIn() {
        System.out.println("Il volontario " + nome + " ha iniziato il servizio.");
    }

}
