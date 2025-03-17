package it.epicode.esericizio3;

import lombok.Data;

@Data
public class ContoOnLine extends ContoCorrente{
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP){
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo(){
        System.out.println("Titolare: " + getTitolare() + " - Saldo: " + getSaldo() + " - Num movimenti: " + getNMovimenti() + " - Massimo movimenti: " + getMaxMovimenti() + " - Massimo prelievo possibile: " + getMaxPrelievo());
    }

    public void preleva(double x) throws BancaException {
        if (x <= maxPrelievo) super.preleva(x);
        if (x > maxPrelievo){
            throw new BancaException("Il prelievo non è disponibile");
        }
    }
}
