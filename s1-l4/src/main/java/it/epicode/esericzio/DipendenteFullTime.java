package it.epicode.esericzio;


public class DipendenteFullTime extends Dipendente{
    public DipendenteFullTime(int matricola, double salarioFisso, Dipartimento dipartimento) {
        super(matricola, salarioFisso, dipartimento);
        this.salarioFisso = salarioFisso;
    }

    private double salarioFisso;
    public double calculateSalary() {
        return salarioFisso;
    }
}
