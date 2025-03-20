package it.epicode.esercizio4;

import it.epicode.eccomerce.Customer;
import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Order;
import it.epicode.eccomerce.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<Order> ordini = ListeEcommerce.getOrders();

        Map<Customer, Double> sommaOrdiniXCliente = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum())));

        sommaOrdiniXCliente.forEach((customer, sommaOrdini) -> {
            System.out.println("Cliente: " + customer.getName());
            System.out.println("Somma ordini: " + sommaOrdini);
        });

        // media del prezzo degli ordini
        double mediaOrdini = sommaOrdiniXCliente.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

    }
}
