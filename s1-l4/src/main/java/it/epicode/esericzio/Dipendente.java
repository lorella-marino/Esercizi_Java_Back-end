package it.epicode.esericzio;


import lombok.Getter;
import lombok.Setter;


public abstract class Dipendente implements CheckIn{
    @Getter
    private int matricola;
    @Getter
    private double stipendio;
    @Setter
    private Dipartimento tipo;

    public Dipendente(int matricola, double stipendio, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.tipo = dipartimento;
    }

    public abstract double calculateSalary();

    @Override
    public void checkIn() {
        System.out.println("Il dipendente " + matricola + " ha iniziato il turno.");
    }

}
