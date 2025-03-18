package it.epicode.esercizio3;

public class Contatto {
    private String nome;
    private int numeroTelefono;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Contatto(String nome, int numeroTelefono) {
        this.nome = nome;
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return ", numeroTelefono: " + numeroTelefono;
    }
}
