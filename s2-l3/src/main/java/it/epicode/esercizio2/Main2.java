package it.epicode.esercizio2;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Order;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("Lista di id degli ordini con prodotti della categoria Baby:");
        List<Order> categoriaBaby = ListeEcommerce.getOrders();
        categoriaBaby.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby"))
                        )
                .forEach (order -> System.out.println(order.getId()));
    }
}
