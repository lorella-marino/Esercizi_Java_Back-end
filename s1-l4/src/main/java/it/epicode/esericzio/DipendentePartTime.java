package it.epicode.esericzio;

public class DipendentePartTime extends Dipendente{

    private double oreDiLavoro;
    private double pagaOraria;
    private double giorniDiLavoro = 22;

    public DipendentePartTime(int matricola, Dipartimento dipartimento, double oreDiLavoro, double pagaOraria) {
        super(matricola, oreDiLavoro*pagaOraria, dipartimento);
        this.oreDiLavoro = oreDiLavoro;
        this.pagaOraria = pagaOraria;
    }

    public double calculateSalary() {
        return oreDiLavoro*pagaOraria*giorniDiLavoro;
    }
}
