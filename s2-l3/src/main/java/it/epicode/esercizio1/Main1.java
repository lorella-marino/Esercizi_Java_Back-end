package it.epicode.esercizio1;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Product;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Product> categoriaBooks = ListeEcommerce.getProducts();
        categoriaBooks.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100).toList()
                .forEach(System.out::println);
    }
}
