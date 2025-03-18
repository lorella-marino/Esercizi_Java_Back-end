package it.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Map<String, Contatto> rubrica = new HashMap<>();
        rubrica.put("Mario", new Contatto("Mario", 123456789));
        rubrica.put("Luigi", new Contatto("Luigi", 987654321));
        rubrica.put("Giovanni", new Contatto("Giovanni", 37383939));
        rubrica.put("Pietro", new Contatto("Pietro", 22938302));

        for (String key : rubrica.keySet()) {
            System.out.println(key + " " + rubrica.get(key));
        }

        System.out.println(" ");

        // rimuove Giovanni
        rubrica.remove("Giovanni");
        for (String key : rubrica.keySet()) {
            System.out.println(key + " " + rubrica.get(key));
        }

        System.out.println(" ");

        // ricerca persona dal numero
        for (String key : rubrica.keySet()) {
            if (rubrica.get(key).getNumeroTelefono() == 22938302) {
                System.out.println("La persona è " + key);
            }
        }

        System.out.println(" ");

        // ricerca numero dalla persona
        for (String key : rubrica.keySet()) {
            if (rubrica.get(key).getNome() == "Mario"){
                System.out.println("Il numero di " + key + " è "+ rubrica.get(key).getNumeroTelefono());
            }
        }


    }
}
