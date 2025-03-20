package it.epicode.esercizio2;

import it.epicode.eccomerce.Customer;
import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Order;
import it.epicode.eccomerce.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Order> ordini = ListeEcommerce.getOrders();

        // mappa in cui la key è il customer e il value è la somma degli ordini
        Map<Customer, Double> sommaOrdiniXCliente = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum())));

        sommaOrdiniXCliente.forEach((customer, sommaOrdini) -> {
            System.out.println("Cliente: " + customer.getName());
            System.out.println("Somma ordini: " + sommaOrdini);
        });
    }
}
