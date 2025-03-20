package it.epicode.esercizio5;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public static void main(String[] args) {
        Map<String,Double> sommaCategoria = ListeEcommerce.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
        sommaCategoria.forEach((categoria, somma) -> {
            System.out.println("Categoria: " + categoria + " - Somma: " + somma);
        });
    }
}
