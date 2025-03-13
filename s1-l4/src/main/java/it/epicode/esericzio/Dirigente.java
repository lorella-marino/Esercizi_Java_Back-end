package it.epicode.esericzio;

public class Dirigente extends Dipendente{
    public Dirigente(int matricola, double salarioFisso, Dipartimento dipartimento) {
        super(matricola, salarioFisso, dipartimento);
        this.salarioFisso = salarioFisso;
    }

    private double salarioFisso;
    public double calculateSalary() {
        return salarioFisso*2;
    }
}
