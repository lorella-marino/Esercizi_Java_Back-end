package it.epicode.esercizio3;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Product> categoriaBooks = ListeEcommerce.getProducts();

        List<Product> top3Costosi = categoriaBooks.stream()
                .sorted(Comparator.comparing(Product::getPrice)
                        .reversed())
                .limit(3)
                .toList();

        top3Costosi.forEach(product -> System.out.println("Nome: " + product.getName() + ", Prezzo: " + product.getPrice()));
    }
}
