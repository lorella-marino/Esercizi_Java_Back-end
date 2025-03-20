package it.epicode.esercizio3;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Product;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<Product> categoriaBoys = ListeEcommerce.getProducts();
        categoriaBoys.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {product.setPrice(product.getPrice() * 0.9); // map modifica ogni prodotto
                return product;}) // ritorna il prodotto modificato
                .forEach(System.out::println);
    }
}
