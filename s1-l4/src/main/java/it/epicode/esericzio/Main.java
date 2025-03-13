package it.epicode.esericzio;

public class Main {
    public static void main(String[] args) {

        DipendenteFullTime dipendenteFullTime = new DipendenteFullTime(12345, 2000, Dipartimento.PRODUZIONE);

        DipendentePartTime dipendentePartTime = new DipendentePartTime(45678, Dipartimento.AMMINISTRAZIONE, 5, 10);

        Dirigente dirigente = new Dirigente(78901, 2000, Dipartimento.VENDITE );

        Dipendente[] dipendenti = {dipendenteFullTime, dipendentePartTime, dirigente};

        System.out.println("");
        System.out.println("--- Esercizio 1 ---");
        System.out.println("Matricola dipendenti:");
        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente.getClass().getSimpleName() + ": " + dipendente.getMatricola());
        }

        System.out.println("");
        System.out.println("--- Esercizio 2 ---");

        System.out.println("Salario dipendenteFullTime: "+ dipendenteFullTime.calculateSalary() + "€");
        System.out.println("Salario dipendentePartTime: "+ dipendentePartTime.calculateSalary() + "€");
        System.out.println("Salario Dirigente: "+ dirigente.calculateSalary() + "€");


        System.out.println("");
        System.out.println("--- Esercizio 3 ---");
        Volontario volontario1 = new Volontario("Mario", 25, "CV di Mario");
        Volontario volontario2 = new Volontario("Luigi", 30, "CV di Luigi");

        // array di volontari e dipendenti
        CheckIn[] arrayCheckIn = {volontario1, volontario2, dipendenteFullTime, dipendentePartTime, dirigente};
        System.out.println("CheckIn:");
        for (CheckIn checkIn : arrayCheckIn){
            checkIn.checkIn();
        }


    }
}
